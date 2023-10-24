package com.ordana.molten_metals.configs;

import com.ordana.molten_metals.MoltenMetals;
import net.mehvahdjukaar.moonlight.api.platform.configs.ConfigBuilder;
import net.mehvahdjukaar.moonlight.api.platform.configs.ConfigSpec;
import net.mehvahdjukaar.moonlight.api.platform.configs.ConfigType;

import java.util.function.Supplier;

public class CommonConfigs {
    public static ConfigSpec SERVER_SPEC;

    public static Supplier<Boolean> CREATIVE_TAB;


    public static void init() {
        // bump class load init
    }

    static {
        ConfigBuilder builder = ConfigBuilder.create(MoltenMetals.res("common"), ConfigType.COMMON);

        builder.setSynced();

        builder.push("misc");
        CREATIVE_TAB = builder.define("creative_tab", false);
        builder.pop();

        SERVER_SPEC = builder.buildAndRegister();
        SERVER_SPEC.loadFromFile();
    }
}