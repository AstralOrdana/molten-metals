package com.ordana.molten_metals.reg;

import com.ordana.molten_metals.MoltenMetals;
import com.ordana.molten_metals.items.MoltenMetalBucketItem;
import net.mehvahdjukaar.moonlight.api.platform.RegHelper;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ModItems {

    public static void init() {
    }

    public static <T extends Item> Supplier<T> regItem(String name, Supplier<T> itemSup) {
        return RegHelper.registerItem(MoltenMetals.res(name), itemSup);
    }

    //Buckets
    public static final Supplier<Item> MOLTEN_IRON_BUCKET = regItem("molten_iron_bucket", () ->
            new MoltenMetalBucketItem(ModFluids.MOLTEN_IRON.get(), (new Item.Properties().stacksTo(1))));
    public static final Supplier<Item> MOLTEN_COPPER_BUCKET = regItem("molten_copper_bucket", () ->
            new MoltenMetalBucketItem(ModFluids.MOLTEN_COPPER.get(), (new Item.Properties().stacksTo(1))));
    public static final Supplier<Item> MOLTEN_GOLD_BUCKET = regItem("molten_gold_bucket", () ->
            new MoltenMetalBucketItem(ModFluids.MOLTEN_GOLD.get(), (new Item.Properties().stacksTo(1))));
    public static final Supplier<Item> MOLTEN_NETHERITE_BUCKET = regItem("molten_netherite_bucket", () ->
            new MoltenMetalBucketItem(ModFluids.MOLTEN_NETHERITE.get(), (new Item.Properties().stacksTo(1))));
    public static final Supplier<Item> MOLTEN_ZINC_BUCKET = regItem("molten_zinc_bucket", () ->
            new MoltenMetalBucketItem(ModFluids.MOLTEN_ZINC.get(), (new Item.Properties().stacksTo(1))));
    public static final Supplier<Item> MOLTEN_BRASS_BUCKET = regItem("molten_brass_bucket", () ->
            new MoltenMetalBucketItem(ModFluids.MOLTEN_BRASS.get(), (new Item.Properties().stacksTo(1))));

    public static final Supplier<Item> MOLTEN_BISMUTH_BUCKET = regItem("molten_bismuth_bucket", () ->
            new MoltenMetalBucketItem(ModFluids.MOLTEN_BISMUTH.get(), (new Item.Properties().stacksTo(1))));
    public static final Supplier<Item> MOLTEN_MERCURY_BUCKET = regItem("molten_mercury_bucket", () ->
            new MoltenMetalBucketItem(ModFluids.MOLTEN_MERCURY.get(), (new Item.Properties().stacksTo(1))));


    public static final Supplier<Item> UNFIRED_CERAMIC_INGOT_MOLD = regItem("unfired_ceramic_ingot_mold", () ->
            new Item(new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> CERAMIC_INGOT_MOLD = regItem("ceramic_ingot_mold", () ->
            new Item(new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> INGOT_MOLD = regItem("ingot_mold", () ->
            new Item(new Item.Properties().stacksTo(16)));
    
    public static final Supplier<Item> MOLTEN_IRON_CERAMIC_INGOT_MOLD = regItem("molten_iron_ceramic_ingot_mold", () ->
            new Item(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> MOLTEN_COPPER_CERAMIC_INGOT_MOLD = regItem("molten_copper_ceramic_ingot_mold", () ->
            new Item(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> MOLTEN_GOLD_CERAMIC_INGOT_MOLD = regItem("molten_gold_ceramic_ingot_mold", () ->
            new Item(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> MOLTEN_NETHERITE_CERAMIC_INGOT_MOLD = regItem("molten_netherite_ceramic_ingot_mold", () ->
            new Item(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> MOLTEN_ZINC_CERAMIC_INGOT_MOLD = regItem("molten_zinc_ceramic_ingot_mold", () ->
            new Item(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> MOLTEN_BRASS_CERAMIC_INGOT_MOLD = regItem("molten_brass_ceramic_ingot_mold", () ->
            new Item(new Item.Properties().stacksTo(1)));

    public static final Supplier<Item> MOLTEN_BISMUTH_CERAMIC_INGOT_MOLD = regItem("molten_bismuth_ceramic_ingot_mold", () ->
            new Item(new Item.Properties().stacksTo(1)));


    public static final Supplier<Item> MOLTEN_IRON_INGOT_MOLD = regItem("molten_iron_ingot_mold", () ->
            new Item(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> MOLTEN_COPPER_INGOT_MOLD = regItem("molten_copper_ingot_mold", () ->
            new Item(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> MOLTEN_GOLD_INGOT_MOLD = regItem("molten_gold_ingot_mold", () ->
            new Item(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> MOLTEN_NETHERITE_INGOT_MOLD = regItem("molten_netherite_ingot_mold", () ->
            new Item(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> MOLTEN_ZINC_INGOT_MOLD = regItem("molten_zinc_ingot_mold", () ->
            new Item(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> MOLTEN_BRASS_INGOT_MOLD = regItem("molten_brass_ingot_mold", () ->
            new Item(new Item.Properties().stacksTo(1)));

    public static final Supplier<Item> MOLTEN_BISMUTH_INGOT_MOLD = regItem("molten_bismuth_ingot_mold", () ->
        new Item(new Item.Properties().stacksTo(1)));
}

