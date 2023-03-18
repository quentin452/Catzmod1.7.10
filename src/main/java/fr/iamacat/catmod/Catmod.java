package fr.iamacat.catmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fr.iamacat.catmod.init.RegisterItems;
import fr.iamacat.catmod.proxy.IProxy;
import fr.iamacat.catmod.utils.CatTab;
import fr.iamacat.catmod.utils.Reference;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = Reference.MOD_ID , name = Reference.MOD_NAME,version = Reference.MOD_VERSION, acceptedMinecraftVersions = Reference.MC_VERSION)
public class Catmod {
    @Mod.Instance
    public static Catmod Instance;
    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static IProxy proxy;

    public static CreativeTabs catTab = new CatTab("catTaB");


    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        RegisterItems.init();
        RegisterItems.register();
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {

    }

    @Mod.EventHandler
    public static void Init(FMLInitializationEvent event) {

    }
}
