package fr.iamacat.catmod;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.catmod.blocks.CatOre;
import fr.iamacat.catmod.entities.EntityCatTnt;
import fr.iamacat.catmod.entities.RenderCatTnt;
import fr.iamacat.catmod.init.RegisterBlocks;
import fr.iamacat.catmod.init.RegisterItems;
import fr.iamacat.catmod.proxy.IProxy;
import fr.iamacat.catmod.utils.CatTab;
import fr.iamacat.catmod.utils.Reference;
import fr.iamacat.catmod.worldgen.CatOreGen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, acceptedMinecraftVersions = Reference.MC_VERSION)
public class Catmod {
    @Mod.Instance
    public static Catmod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static IProxy proxy;

    public static CreativeTabs catTab = new CatTab("catTab");

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        RegisterItems.init();
        RegisterItems.register();
        RegisterBlocks.init();
        RegisterBlocks.register();
        GameRegistry.registerWorldGenerator(new CatOreGen(), 0);

        // Register your custom entity here
        EntityRegistry.registerModEntity(EntityCatTnt.class, "my_custom_entity", 1, Catmod.instance, 64, 1, true);


        // Register your entity rendering handler
        int entityId = EntityRegistry.findGlobalUniqueEntityId();
        RenderingRegistry.registerEntityRenderingHandler(EntityCatTnt.class, new RenderCatTnt());
        // If you want to add more custom entities, you can use the code below as a template
        /*
 EntityRegistry.registerModEntity(EntityCatTnt.class, "my_custom_entity", 1, Catmod.instance, 64, 1, true);
 RenderingRegistry.registerEntityRenderingHandler(EntityCatTnt.class, new EntityCatTnt.RenderCatTnt(RenderManager.instance));
        */
}

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
    }


    @Mod.EventHandler
    public static void Init(FMLInitializationEvent event) {
    }
}
