package com.ordana.template_mod.forge;

import com.ordana.template_mod.TemplateMod;
import net.minecraftforge.fml.common.Mod;

@Mod(TemplateMod.MOD_ID)
public class TemplateModForge {

    public TemplateModForge() {
        TemplateMod.commonInit();
        /*
        if (PlatformHelper.getEnv().isClient()) {
            ModidClient.init();
        }
        */
    }
}

