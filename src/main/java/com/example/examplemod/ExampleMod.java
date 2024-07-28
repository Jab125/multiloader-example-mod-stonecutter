package com.example.examplemod;

//#if LOADER == FORGE
//$$ import net.minecraftforge.fml.common.Mod;
//#elseif LOADER == NEOFORGE
//$$ import net.neoforged.fml.common.Mod;
//#endif
//#if LOADER <= FORGE
//$$ @Mod(ExampleMod.MOD_ID)
//#endif
public class ExampleMod {
    public static final String MOD_ID = "examplemod";

    //#if LOADER <= FORGE
    //$$ public ExampleMod() {
    //$$     onInitialize();
    //$$ }
    //#endif

    public void onInitialize() {
        //#if LOADER == FABRIC
        String loader = "Fabric";
        //#elseif LOADER == FORGE
        //$$ String loader = "Forge";
        //#elseif LOADER == NEOFORGE
        //$$ String loader = "NeoForge";
        //#endif
        System.out.printf("Hello %s World!%n", loader);
        //System.out.println("\u0022");
    }
}
