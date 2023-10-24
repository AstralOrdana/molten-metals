package com.ordana.molten_metals.items;

import net.mehvahdjukaar.moonlight.api.platform.PlatHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;

import java.lang.reflect.Field;

public class MoltenMetalBucketItem extends BucketItem {

    private static final Field CONTENT = PlatHelper.findField(BucketItem.class, "content");

    public MoltenMetalBucketItem(Fluid fluid, Properties properties) {
        super(fluid, properties);
    }

    @Override
    protected void playEmptySound(@org.jetbrains.annotations.Nullable Player player, LevelAccessor level, BlockPos pos) {
        SoundEvent soundEvent = SoundEvents.BUCKET_EMPTY_LAVA;
        level.playSound(player, pos, soundEvent, SoundSource.BLOCKS, 1.0F, 1.0F);
        level.gameEvent(player, GameEvent.FLUID_PLACE, pos);
    }
}