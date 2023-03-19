package fr.iamacat.catmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.catmod.blocks.CatOre;
import fr.iamacat.catmod.blocks.CatTnt;
import fr.iamacat.catmod.init.RegisterBlocks;
import fr.iamacat.catmod.init.RegisterItems;
import fr.iamacat.catmod.proxy.IProxy;
import fr.iamacat.catmod.utils.CatTab;
import fr.iamacat.catmod.utils.Reference;
import fr.iamacat.catmod.worldgen.CatOreGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;

import java.rmi.registry.Registry;

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
        RegisterBlocks.init();
        RegisterBlocks.register();
        GameRegistry.registerWorldGenerator(new CatOreGen(),0);
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {

    }

    @Mod.EventHandler
    public static void Init(FMLInitializationEvent event) {

    }
}
