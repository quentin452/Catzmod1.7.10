package fr.iamacat.catmod;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.catmod.entities.CatAgressiveEntity;
import fr.iamacat.catmod.entities.CatPassiveEntity;
import fr.iamacat.catmod.init.*;
import fr.iamacat.catmod.items.CatSpawnEgg;
import fr.iamacat.catmod.proxy.CommonProxy;
import fr.iamacat.catmod.utils.*;
import fr.iamacat.catmod.worldgen.oregen.CatOreGen;

@Mod(
    modid = Reference.MOD_ID,
    name = Reference.MOD_NAME,
    version = Reference.MOD_VERSION,
    acceptedMinecraftVersions = Reference.MC_VERSION)
public class Catmod {

    // todo fix tooltips for blocks
    @Mod.Instance(Reference.MOD_ID)
    public static Catmod instance;
    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static CommonProxy proxy;
    public static CatTabTools catTab = new CatTabTools("catTab");
    public static CatTabBlocks catTab2 = new CatTabBlocks("catTab2");
    public static CatTabFood catTab3 = new CatTabFood("catTab3");
    public static CatTabSpawn catTab4 = new CatTabSpawn("catTab4");
    public static CatTabMisc catTab5 = new CatTabMisc("catTab5");
    public static Item[] yourTabIcons = { RegisterItems.cat_helmet, RegisterItems.cat_chestplate,
        RegisterItems.cat_leggings, RegisterItems.cat_boots };

    public static CatTabArmour catTab6 = new CatTabArmour("catTab6", yourTabIcons);

    public static CatTabIngots catTab7 = new CatTabIngots("catTab7");

    public static Item CatAgressiveEntitySpawnEgg;
    public static Item CatPassiveEntitySpawnEgg;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        RegisterItems.init();
        RegisterItems.register();
        RegisterBlocks.init();
        RegisterBlocks.register();
        GameRegistry.registerWorldGenerator(new CatOreGen(), 0);
        RegisterBiomes.init();
        RegisterDimension.init();

        // Custom Spawn Eggs
        CatSpawnEgg catAgressiveEntitySpawnEgg = new CatSpawnEgg(CatAgressiveEntity.class);
        catAgressiveEntitySpawnEgg.setUnlocalizedName("cat_agressive_spawn_egg")
            .setCreativeTab(Catmod.catTab4)
            .setTextureName(Reference.MOD_ID + ":eggcatagressiveentity.png");
        CatAgressiveEntitySpawnEgg = catAgressiveEntitySpawnEgg;
        GameRegistry.registerItem(CatAgressiveEntitySpawnEgg, "Cat Agressive Spawn Egg");

        CatSpawnEgg catPassiveEntitySpawnEgg = new CatSpawnEgg(CatPassiveEntity.class);
        catPassiveEntitySpawnEgg.setUnlocalizedName("cat_passive_spawn_egg")
            .setCreativeTab(Catmod.catTab4)
            .setTextureName(Reference.MOD_ID + ":eggcatpassiveentity.png");
        CatPassiveEntitySpawnEgg = catPassiveEntitySpawnEgg;
        GameRegistry.registerItem(CatPassiveEntitySpawnEgg, "Cat Passive Spawn Egg");
    }

    public static class WorldLoadHandler {

    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerFuelHandler(new RegisterFuel());
        // Register the proxy as an event handler
        MinecraftForge.EVENT_BUS.register(proxy);
        proxy.registerRenders();
        proxy.registerEntities();
    }
}
