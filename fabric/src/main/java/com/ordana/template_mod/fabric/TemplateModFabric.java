package com.ordana.template_mod.fabric;

import net.fabricmc.api.ModInitializer;
import com.ordana.template_mod.TemplateMod;
import com.ordana.template_mod.TemplateModClient;
import net.mehvahdjukaar.moonlight.api.platform.PlatformHelper;
import net.mehvahdjukaar.moonlight.fabric.FabricSetupCallbacks;

public class TemplateModFabric implements ModInitializer {

    @Override
    public void onInitialize() {

        TemplateMod.commonInit();

        if (PlatformHelper.getEnv().isClient()) {
            FabricSetupCallbacks.CLIENT_SETUP.add(TemplateModClient::init);
        }
    }
}
