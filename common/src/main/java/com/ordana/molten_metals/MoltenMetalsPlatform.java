package com.ordana.molten_metals;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

public class MoltenMetalsPlatform {

    @ExpectPlatform
    public static LiquidBlock doMoltenMetal(Supplier<FlowingFluid> flowingFluid, BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }
}