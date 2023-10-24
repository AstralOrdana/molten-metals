package com.ordana.molten_metals;

import com.ordana.molten_metals.reg.ModBlocks;
import com.ordana.molten_metals.reg.ModCreativeTabs;
import com.ordana.molten_metals.reg.ModFluids;
import com.ordana.molten_metals.reg.ModItems;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MoltenMetals {

    public static final String MOD_ID = "molten_metals";
    public static final Logger LOGGER = LogManager.getLogger();

    private static final String NAME = "molten_metals";

    public static ResourceLocation res(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

    public static void commonInit() {
        ModBlocks.init();
        ModFluids.init();
        ModItems.init();
        ModCreativeTabs.init();

    }

}