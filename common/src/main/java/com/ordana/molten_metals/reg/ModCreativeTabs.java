package com.ordana.molten_metals.reg;

import com.ordana.molten_metals.MoltenMetals;
import com.ordana.molten_metals.configs.CommonConfigs;
import net.mehvahdjukaar.moonlight.api.misc.RegSupplier;
import net.mehvahdjukaar.moonlight.api.platform.PlatHelper;
import net.mehvahdjukaar.moonlight.api.platform.RegHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ModCreativeTabs {

    public static final RegSupplier<CreativeModeTab> MOD_TAB = !CommonConfigs.CREATIVE_TAB.get() ? null :
            RegHelper.registerCreativeModeTab(MoltenMetals.res("spelunkery"),
                    (c) -> c.title(Component.translatable("itemGroup.spelunkery"))
                            .icon(() -> ModItems.MOLTEN_IRON_BUCKET.get().getDefaultInstance()));


    public static void init() {
        RegHelper.addItemsToTabsRegistration(ModCreativeTabs::registerItemsToTabs);
    }


    public static void registerItemsToTabs(RegHelper.ItemToTabEvent e) {
        after(e, Items.WATER_BUCKET, CreativeModeTabs.TOOLS_AND_UTILITIES, "buckets",
                ModItems.MOLTEN_IRON_BUCKET, ModItems.MOLTEN_COPPER_BUCKET, ModItems.MOLTEN_GOLD_BUCKET,
                ModItems.MOLTEN_NETHERITE_BUCKET, ModItems.MOLTEN_ZINC_BUCKET, ModItems.MOLTEN_BRASS_BUCKET,
                ModItems.UNFIRED_CERAMIC_INGOT_MOLD, ModItems.CERAMIC_INGOT_MOLD, ModItems.INGOT_MOLD,
                ModItems.MOLTEN_IRON_CERAMIC_INGOT_MOLD, ModItems.MOLTEN_COPPER_CERAMIC_INGOT_MOLD, ModItems.MOLTEN_GOLD_CERAMIC_INGOT_MOLD,
                ModItems.MOLTEN_NETHERITE_CERAMIC_INGOT_MOLD, ModItems.MOLTEN_ZINC_CERAMIC_INGOT_MOLD, ModItems.MOLTEN_BRASS_CERAMIC_INGOT_MOLD,
                ModItems.MOLTEN_IRON_INGOT_MOLD, ModItems.MOLTEN_COPPER_INGOT_MOLD, ModItems.MOLTEN_GOLD_INGOT_MOLD,
                ModItems.MOLTEN_NETHERITE_INGOT_MOLD, ModItems.MOLTEN_ZINC_INGOT_MOLD, ModItems.MOLTEN_BRASS_INGOT_MOLD
        );
    }

    private static void after(RegHelper.ItemToTabEvent event, TagKey<Item> target,
                              ResourceKey<CreativeModeTab> tab, String key, Supplier<?>... items) {
        after(event, i -> i.is(target), tab, key, items);
    }

    private static void after(RegHelper.ItemToTabEvent event, Item target,
                              ResourceKey<CreativeModeTab> tab, String key, Supplier<?>... items) {
        after(event, i -> i.is(target), tab, key, items);
    }

    private static void after(RegHelper.ItemToTabEvent event, Predicate<ItemStack> targetPred,
                              ResourceKey<CreativeModeTab> tab, String key, Supplier<?>... items) {
        //if (CommonConfigs.isEnabled(key)) {
        ItemLike[] entries = Arrays.stream(items).map((s -> (ItemLike) (s.get()))).toArray(ItemLike[]::new);
        if(CommonConfigs.CREATIVE_TAB.get()){
            tab = MOD_TAB.getHolder().unwrapKey().get();
        }
        event.addAfter(tab, targetPred, entries);
        //}
    }

    private static void before(RegHelper.ItemToTabEvent event, Item target,
                               ResourceKey<CreativeModeTab> tab, String key, Supplier<?>... items) {
        before(event, i -> i.is(target), tab, key, items);
    }

    private static void before(RegHelper.ItemToTabEvent event, Predicate<ItemStack> targetPred,
                               ResourceKey<CreativeModeTab> tab, String key, Supplier<?>... items) {
        //if (CommonConfigs.isEnabled(key)) {
        ItemLike[] entries = Arrays.stream(items).map(s -> (ItemLike) s.get()).toArray(ItemLike[]::new);
        if(CommonConfigs.CREATIVE_TAB.get()){
            tab = MOD_TAB.getHolder().unwrapKey().get();
        }
        event.addBefore(tab, targetPred, entries);
        //}
    }

    private static void add(RegHelper.ItemToTabEvent event,
                            ResourceKey<CreativeModeTab> tab, String key, Supplier<?>... items) {
        //if (CommonConfigs.isEnabled(key)) {
        ItemLike[] entries = Arrays.stream(items).map((s -> (ItemLike) (s.get()))).toArray(ItemLike[]::new);
        if(CommonConfigs.CREATIVE_TAB.get()){
            tab = MOD_TAB.getHolder().unwrapKey().get();
        }
        event.add(tab, entries);
        //}
    }

    private static void afterML(RegHelper.ItemToTabEvent event, Item target,
                                ResourceKey<CreativeModeTab> tab, String key, String modLoaded,
                                Supplier<?>... items) {
        if (PlatHelper.isModLoaded(modLoaded)) {
            after(event, target, tab, key, items);
        }
    }

    private static void afterTL(RegHelper.ItemToTabEvent event, Item target,
                                ResourceKey<CreativeModeTab> tab, String key,
                                List<String> tags,
                                Supplier<?>... items) {
        if (isTagOn(tags.toArray(String[]::new))) {
            after(event, target, tab, key, items);
        }
    }

    private static void beforeML(RegHelper.ItemToTabEvent event, Item target,
                                 ResourceKey<CreativeModeTab> tab,
                                 String key, String modLoaded,
                                 Supplier<?>... items) {
        if (PlatHelper.isModLoaded(modLoaded)) {
            before(event, target, tab, key, items);
        }
    }

    private static void beforeTL(RegHelper.ItemToTabEvent event, Item target,
                                 ResourceKey<CreativeModeTab> tab, String key,
                                 List<String> tags,
                                 Supplier<?>... items) {
        if (isTagOn(tags.toArray(String[]::new))) {
            after(event, target, tab, key, items);
        }
    }

    private static boolean isTagOn(String... tags) {
        for (var t : tags)
            if (BuiltInRegistries.ITEM.getTag(TagKey.create(Registries.ITEM, new ResourceLocation(t))).isPresent()) {
                return true;
            }
        return false;
    }

}