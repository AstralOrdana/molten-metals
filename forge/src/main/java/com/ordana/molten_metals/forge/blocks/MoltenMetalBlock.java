package com.ordana.molten_metals.forge.blocks;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

public class MoltenMetalBlock extends LiquidBlock {

    public MoltenMetalBlock(Supplier<FlowingFluid> flowingFluid, Properties properties) {
        super(flowingFluid, properties);
    }
}