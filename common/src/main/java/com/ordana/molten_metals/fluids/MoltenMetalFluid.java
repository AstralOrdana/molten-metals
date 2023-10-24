package com.ordana.molten_metals.fluids;

import com.ordana.molten_metals.MoltenMetals;
import com.ordana.molten_metals.reg.ModFluids;
import com.ordana.molten_metals.reg.ModItems;
import net.mehvahdjukaar.moonlight.api.client.ModFluidRenderProperties;
import net.mehvahdjukaar.moonlight.api.fluids.ModFlowingFluid;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Supplier;

public class MoltenMetalFluid extends ModFlowingFluid {

    //private final String string;

    public MoltenMetalFluid(Properties properties, Supplier<? extends LiquidBlock> block) {
        super(properties, block);
    }

    //public MoltenMetalFluid(Properties properties, Supplier<? extends LiquidBlock> block, String string) {
    //    this.string = string;
    //    super(properties, block, string);
    //}

    @Override
    public ModFluidRenderProperties createRenderProperties() {
        return new MoltenMetalRenderer(
                MoltenMetals.res("block/texture"),
                MoltenMetals.res("block/texture_flowing"),
                -1,
                MoltenMetals.res("block/texture_overlay"),
                MoltenMetals.res("block/texture_overlay"),
                new Vec3(133, 0, 0));

    }

    public ModFluidRenderProperties MoltenMetalRenderProperties(String string) {
        return new MoltenMetalRenderer(
                MoltenMetals.res("block/" + string),
                MoltenMetals.res("block/" + string + "_flowing"),
                -1,
                MoltenMetals.res("block/" + string + "_overlay"),
                MoltenMetals.res("block/" + string + "_overlay"),
                new Vec3(133, 0, 0));

    }

    @NotNull
    public Fluid getFlowing() {
        return ModFluids.FLOWING_MOLTEN_BRASS.get();
    }

    @NotNull
    public Fluid getSource() {
        return ModFluids.MOLTEN_BRASS.get();
    }

    @NotNull
    public Item getBucket() {
        return ModItems.MOLTEN_BRASS_BUCKET.get();
    }

    @NotNull
    public Optional<SoundEvent> getPickupSound() {
        return Optional.of(SoundEvents.BUCKET_FILL_LAVA);
    }

    @Override
    protected ParticleOptions getDripParticle() {
        return ParticleTypes.DRIPPING_LAVA;
    }

    public void animateTick(Level level, BlockPos pos, FluidState state, RandomSource random) {
        BlockPos blockPos = pos.above();
        if (level.getBlockState(blockPos).isAir() && !level.getBlockState(blockPos).isSolidRender(level, blockPos)) {
            if (random.nextInt(20) == 0) {
                double d = (double)pos.getX() + random.nextDouble();
                double e = (double)pos.getY() + 1.0D;
                double f = (double)pos.getZ() + random.nextDouble();
                //level.addParticle(ModParticles.PORTAL_FLAME.get(), d, e + 0.2, f, 0.0D, 0.0D, 0.0D);
                //level.playLocalSound(d, e, f, SoundEvents.LAVA_POP, SoundSource.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
            }

            if (random.nextInt(200) == 0) {
                //level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), ModSoundEvents.PORTAL_FLUID_AMBIENT.get(), SoundSource.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
            }
        }

    }

    @Override
    protected int getSlopeFindDistance(@NotNull LevelReader level) {
        return 2;
    }

    @Override
    protected int getDropOff(@NotNull LevelReader level) {
        return 2;
    }

    @Override
    public int getTickDelay(@NotNull LevelReader level) {
        return 20;
    }

    @Override
    protected float getExplosionResistance() {
        return 100f;
    }

    @Override
    public boolean isSource(@NotNull FluidState state) {
        return false;
    }

    @Override
    public int getAmount(@NotNull FluidState state) {
        return 0;
    }

    protected boolean isRandomlyTicking() {
        return true;
    }

    public void randomTick(Level level, BlockPos pos, FluidState state, RandomSource random) {
        if (level.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
            int i = random.nextInt(3);
            if (i > 0) {
                BlockPos blockPos = pos;

                for(int j = 0; j < i; ++j) {
                    blockPos = blockPos.offset(random.nextInt(3) - 1, 1, random.nextInt(3) - 1);
                    if (!level.isLoaded(blockPos)) {
                        return;
                    }

                    BlockState blockState = level.getBlockState(blockPos);
                    if (blockState.isAir()) {
                        if (this.hasFlammableNeighbours(level, blockPos)) {
                            level.setBlockAndUpdate(blockPos, BaseFireBlock.getState(level, blockPos));
                            return;
                        }
                    } else if (blockState.blocksMotion()) {
                        return;
                    }
                }
            } else {
                for(int k = 0; k < 3; ++k) {
                    BlockPos blockPos2 = pos.offset(random.nextInt(3) - 1, 0, random.nextInt(3) - 1);
                    if (!level.isLoaded(blockPos2)) {
                        return;
                    }

                    if (level.isEmptyBlock(blockPos2.above()) && this.isFlammable(level, blockPos2)) {
                        level.setBlockAndUpdate(blockPos2.above(), BaseFireBlock.getState(level, blockPos2));
                    }
                }
            }

        }
    }

    private boolean hasFlammableNeighbours(LevelReader level, BlockPos pos) {
        Direction[] var3 = Direction.values();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Direction direction = var3[var5];
            if (this.isFlammable(level, pos.relative(direction))) {
                return true;
            }
        }

        return false;
    }

    private boolean isFlammable(LevelReader level, BlockPos pos) {
        return pos.getY() >= level.getMinBuildHeight() && pos.getY() < level.getMaxBuildHeight() && !level.hasChunkAt(pos) ? false : level.getBlockState(pos).ignitedByLava();
    }

    public static class Flowing extends MoltenMetalFluid {
        public Flowing(Properties properties, Supplier<? extends LiquidBlock> block) {
            super(properties, block);
        }

        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(@NotNull FluidState state) {
            return state.getValue(LEVEL);
        }

        @Override
        public boolean isSource(@NotNull FluidState state) {
            return false;
        }
    }

    public static class Source extends MoltenMetalFluid {
        public Source(Properties properties, Supplier<? extends LiquidBlock> block) {
            super(properties, block);
        }

        @Override
        public int getAmount(@NotNull FluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(@NotNull FluidState state) {
            return true;
        }
    }
}