package com.ordana.molten_metals.forge;

import com.ordana.molten_metals.forge.blocks.MoltenMetalBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

public class MoltenMetalsPlatformImpl {

    public static LiquidBlock doMoltenMetal(Supplier<FlowingFluid> flowingFluid, BlockBehaviour.Properties properties) {
        return new MoltenMetalBlock(flowingFluid, properties);
    }
}