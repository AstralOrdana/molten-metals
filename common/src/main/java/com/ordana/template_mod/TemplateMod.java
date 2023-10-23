package com.ordana.template_mod;

import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TemplateMod {

    public static final String MOD_ID = "template_mod";
    public static final Logger LOGGER = LogManager.getLogger();

    private static final String NAME = "template_mod";

    public static ResourceLocation res(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

    public static void commonInit() {

    }

}