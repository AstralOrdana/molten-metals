package com.ordana.molten_metals.fabric;

import com.ordana.molten_metals.MoltenMetals;
import com.ordana.molten_metals.MoltenMetalsClient;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.mehvahdjukaar.moonlight.api.platform.PlatHelper;
import net.minecraft.server.MinecraftServer;

public class MoltenMetalsFabric implements ModInitializer {

    public static MinecraftServer currentServer;

    @Override
    public void onInitialize() {
        MoltenMetals.commonInit();

        ServerLifecycleEvents.SERVER_STARTING.register(s -> currentServer = s);

        if(PlatHelper.getPhysicalSide().isClient()) {
            MoltenMetalsClient.init();
        }

    }
}