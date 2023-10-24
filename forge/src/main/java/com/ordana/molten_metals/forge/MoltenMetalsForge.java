package com.ordana.molten_metals.forge;

import com.ordana.molten_metals.MoltenMetals;
import net.minecraftforge.fml.common.Mod;

@Mod(MoltenMetals.MOD_ID)
public class MoltenMetalsForge {

    public MoltenMetalsForge() {
        MoltenMetals.commonInit();
        /*
        if (PlatformHelper.getEnv().isClient()) {
            ModidClient.init();
        }
        */
    }
}

