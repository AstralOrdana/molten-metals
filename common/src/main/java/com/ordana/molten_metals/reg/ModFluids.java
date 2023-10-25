package com.ordana.molten_metals.reg;

import com.ordana.molten_metals.MoltenMetals;
import com.ordana.molten_metals.fluids.*;
import net.mehvahdjukaar.moonlight.api.fluids.ModFlowingFluid;
import net.mehvahdjukaar.moonlight.api.platform.RegHelper;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluids;

import java.util.function.Supplier;

public class ModFluids extends Fluids {
    public static void  init() {
    }

    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_IRON = RegHelper.registerFluid(MoltenMetals.res("flowing_molten_iron"), () ->
            new MoltenIronFluid.Flowing(ModFlowingFluid.properties().supportsBoating(true).lightLevel(8), ModBlocks.MOLTEN_IRON));
    public static final Supplier<FlowingFluid> MOLTEN_IRON = RegHelper.registerFluid(MoltenMetals.res("molten_iron"), () ->
            new MoltenIronFluid.Source(ModFlowingFluid.properties().supportsBoating(true).lightLevel(8), ModBlocks.MOLTEN_IRON));

    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_COPPER = RegHelper.registerFluid(MoltenMetals.res("flowing_molten_copper"), () ->
            new MoltenCopperFluid.Flowing(ModFlowingFluid.properties().supportsBoating(true).lightLevel(8), ModBlocks.MOLTEN_COPPER));
    public static final Supplier<FlowingFluid> MOLTEN_COPPER = RegHelper.registerFluid(MoltenMetals.res("molten_copper"), () ->
            new MoltenCopperFluid.Source(ModFlowingFluid.properties().supportsBoating(true).lightLevel(8), ModBlocks.MOLTEN_COPPER));

    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_GOLD = RegHelper.registerFluid(MoltenMetals.res("flowing_molten_gold"), () ->
            new MoltenGoldFluid.Flowing(ModFlowingFluid.properties().supportsBoating(true).lightLevel(8), ModBlocks.MOLTEN_GOLD));
    public static final Supplier<FlowingFluid> MOLTEN_GOLD = RegHelper.registerFluid(MoltenMetals.res("molten_gold"), () ->
            new MoltenGoldFluid.Source(ModFlowingFluid.properties().supportsBoating(true).lightLevel(8), ModBlocks.MOLTEN_GOLD));

    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_NETHERITE = RegHelper.registerFluid(MoltenMetals.res("flowing_molten_netherite"), () ->
            new MoltenNetheriteFluid.Flowing(ModFlowingFluid.properties().supportsBoating(true).lightLevel(8), ModBlocks.MOLTEN_NETHERITE));
    public static final Supplier<FlowingFluid> MOLTEN_NETHERITE = RegHelper.registerFluid(MoltenMetals.res("molten_netherite"), () ->
            new MoltenNetheriteFluid.Source(ModFlowingFluid.properties().supportsBoating(true).lightLevel(8), ModBlocks.MOLTEN_NETHERITE));

    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_ZINC = RegHelper.registerFluid(MoltenMetals.res("flowing_molten_zinc"), () ->
            new MoltenZincFluid.Flowing(ModFlowingFluid.properties().supportsBoating(true).lightLevel(8), ModBlocks.MOLTEN_ZINC));
    public static final Supplier<FlowingFluid> MOLTEN_ZINC = RegHelper.registerFluid(MoltenMetals.res("molten_zinc"), () ->
            new MoltenZincFluid.Source(ModFlowingFluid.properties().supportsBoating(true).lightLevel(8), ModBlocks.MOLTEN_ZINC));

    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_BRASS = RegHelper.registerFluid(MoltenMetals.res("flowing_molten_brass"), () ->
            new MoltenBrassFluid.Flowing(ModFlowingFluid.properties().supportsBoating(true).lightLevel(8), ModBlocks.MOLTEN_BRASS));
    public static final Supplier<FlowingFluid> MOLTEN_BRASS = RegHelper.registerFluid(MoltenMetals.res("molten_brass"), () ->
            new MoltenBrassFluid.Source(ModFlowingFluid.properties().supportsBoating(true).lightLevel(8), ModBlocks.MOLTEN_BRASS));

    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_BISMUTH = RegHelper.registerFluid(MoltenMetals.res("flowing_molten_bismuth"), () ->
            new MoltenBismuthFluid.Flowing(ModFlowingFluid.properties().supportsBoating(true).lightLevel(8), ModBlocks.MOLTEN_BISMUTH));
    public static final Supplier<FlowingFluid> MOLTEN_BISMUTH = RegHelper.registerFluid(MoltenMetals.res("molten_bismuth"), () ->
            new MoltenBismuthFluid.Source(ModFlowingFluid.properties().supportsBoating(true).lightLevel(8), ModBlocks.MOLTEN_BISMUTH));

    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_MERCURY = RegHelper.registerFluid(MoltenMetals.res("flowing_molten_mercury"), () ->
            new MoltenMercuryFluid.Flowing(ModFlowingFluid.properties().supportsBoating(true).lightLevel(8), ModBlocks.MOLTEN_MERCURY));
    public static final Supplier<FlowingFluid> MOLTEN_MERCURY = RegHelper.registerFluid(MoltenMetals.res("molten_mercury"), () ->
            new MoltenMercuryFluid.Source(ModFlowingFluid.properties().supportsBoating(true).lightLevel(8), ModBlocks.MOLTEN_MERCURY));

}
