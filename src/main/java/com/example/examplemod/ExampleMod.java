package com.example.examplemod;

//? if fabric
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
//? if forge {
/*import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
*///?} if neoforge {
/*import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
*///?}
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//? if forge || neoforge
/*@Mod(ExampleMod.MOD_ID)*/
public class ExampleMod {
    public static final String MOD_ID = "examplemod";
    public static final Logger LOGGER = LoggerFactory.getLogger(getDisplayName(MOD_ID));

    private static String getDisplayName(String modId) {
        //? if fabric
        return FabricLoader.getInstance().getModContainer(modId).orElseThrow().getMetadata().getName();
        //? if forge
        /*return ModList.get().getModContainerById(modId).orElseThrow().getModInfo().getDisplayName();*/
        //? if neoforge
        /*return ModList.get().getModContainerById(modId).orElseThrow().getModInfo().getDisplayName();*/
    }

    //? if forge || neoforge {
    /*public ExampleMod() {
        onInitialize();
    }
    *///?}

    public void onInitialize() {
        //? if fabric
        String loader = "Fabric";
        //? if forge
        /*String loader = "Forge";*/
        //? if neoforge
        /*String loader = "NeoForge";*/
        LOGGER.info("Hello {} World!", loader);
        // This is a test to assert that the access widener works.
        LOGGER.info("Minecraft: {}", Minecraft.instance);
    }
}
