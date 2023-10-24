package com.ordana.molten_metals.fabric.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

public class MoltenMetalBlock extends LiquidBlock {

    public MoltenMetalBlock(FlowingFluid flowingFluid, Properties properties) {
        super(flowingFluid, properties);
    }

    public boolean isRandomlyTicking(BlockState state) {
        return state.getFluidState().isRandomlyTicking();
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        state.getFluidState().randomTick(level, pos, random);
    }
}