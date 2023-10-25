package com.ordana.molten_metals.reg;

import com.ordana.molten_metals.MoltenMetals;
import com.ordana.molten_metals.MoltenMetalsPlatform;
import net.mehvahdjukaar.moonlight.api.platform.RegHelper;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class ModBlocks {

    public static void init() {
    }

    public static <T extends Block> Supplier<T> regBlock(String name, Supplier<T> block) {
        return RegHelper.registerBlock(MoltenMetals.res(name), block);
    }

    public static <T extends Block> Supplier<T> regWithItem(String name, Supplier<T> blockFactory) {
        Supplier<T> block = regBlock(name, blockFactory);
        regBlockItem(name, block, new Item.Properties());
        return block;
    }

    public static Supplier<BlockItem> regBlockItem(String name, Supplier<? extends Block> blockSup, Item.Properties properties) {
        return RegHelper.registerItem(MoltenMetals.res(name), () -> new BlockItem(blockSup.get(), properties));
    }

    public static final Supplier<LiquidBlock> MOLTEN_IRON = regBlock("molten_iron", () ->
            MoltenMetalsPlatform.doMoltenMetal(ModFluids.MOLTEN_IRON, BlockBehaviour.Properties.copy(Blocks.LAVA).noCollission().strength(100f).noLootTable().lightLevel((blockStatex) -> 8)));
    public static final Supplier<LiquidBlock> MOLTEN_COPPER = regBlock("molten_copper", () ->
            MoltenMetalsPlatform.doMoltenMetal(ModFluids.MOLTEN_COPPER, BlockBehaviour.Properties.copy(Blocks.LAVA).noCollission().strength(100f).noLootTable().lightLevel((blockStatex) -> 8)));
    public static final Supplier<LiquidBlock> MOLTEN_GOLD = regBlock("molten_gold", () ->
            MoltenMetalsPlatform.doMoltenMetal(ModFluids.MOLTEN_GOLD, BlockBehaviour.Properties.copy(Blocks.LAVA).noCollission().strength(100f).noLootTable().lightLevel((blockStatex) -> 8)));
    public static final Supplier<LiquidBlock> MOLTEN_NETHERITE = regBlock("molten_netherite", () ->
            MoltenMetalsPlatform.doMoltenMetal(ModFluids.MOLTEN_NETHERITE, BlockBehaviour.Properties.copy(Blocks.LAVA).noCollission().strength(100f).noLootTable().lightLevel((blockStatex) -> 8)));
    public static final Supplier<LiquidBlock> MOLTEN_ZINC = regBlock("molten_zinc", () ->
            MoltenMetalsPlatform.doMoltenMetal(ModFluids.MOLTEN_ZINC, BlockBehaviour.Properties.copy(Blocks.LAVA).noCollission().strength(100f).noLootTable().lightLevel((blockStatex) -> 8)));
    public static final Supplier<LiquidBlock> MOLTEN_BRASS = regBlock("molten_brass", () ->
            MoltenMetalsPlatform.doMoltenMetal(ModFluids.MOLTEN_BRASS, BlockBehaviour.Properties.copy(Blocks.LAVA).noCollission().strength(100f).noLootTable().lightLevel((blockStatex) -> 8)));

    public static final Supplier<LiquidBlock> MOLTEN_BISMUTH = regBlock("molten_bismuth", () ->
            MoltenMetalsPlatform.doMoltenMetal(ModFluids.MOLTEN_BISMUTH, BlockBehaviour.Properties.copy(Blocks.LAVA).noCollission().strength(100f).noLootTable().lightLevel((blockStatex) -> 8)));
    public static final Supplier<LiquidBlock> MOLTEN_MERCURY = regBlock("molten_mercury", () ->
            MoltenMetalsPlatform.doMoltenMetal(ModFluids.MOLTEN_MERCURY, BlockBehaviour.Properties.copy(Blocks.LAVA).noCollission().strength(100f).noLootTable().lightLevel((blockStatex) -> 8)));


}
