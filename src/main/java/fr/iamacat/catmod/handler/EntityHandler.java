package fr.iamacat.catmod.handler;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import fr.iamacat.catmod.Catmod;
import fr.iamacat.catmod.biomes.catbiome.CatBiome;
import fr.iamacat.catmod.entities.CatAgressiveEntity;
import fr.iamacat.catmod.entities.tnt.EntityCatTnt;
import fr.iamacat.catmod.renders.tnt.RenderCatTnt;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager;

import java.awt.*;
import java.util.Random;

public class EntityHandler
{

    public static void registerMonster(Class entityclass, String string){
        int entityID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(entityclass, string, entityID, new Color(0, 221, 243).getRGB(), new Color(243, 0, 0).getRGB());// to make eggs for the entity
        EntityRegistry.addSpawn(string, 100, 2,4, EnumCreatureType.monster, BiomeGenBase.beach,BiomeGenBase.desert,BiomeGenBase.forest,BiomeGenBase.plains,CatBiome.INSTANCE);
        EntityRegistry.registerModEntity(entityclass, string, entityID, Catmod.instance,32,1,true);

        //EntityRegistry.registerModEntity(EntityCatTnt.class, "CatTntEntity", 1, Catmod.instance, 64, 1, true);
        //add for tnt
    }
    public static void registerCreature(Class entityclass, String string){
        int entityID = EntityRegistry.findGlobalUniqueEntityId();

       EntityRegistry.registerGlobalEntityID(entityclass, string, entityID, new Color(60, 253, 1).getRGB(), new Color(0, 235, 243).getRGB());// to make eggs for the entity
       EntityRegistry.addSpawn(string, 100, 2,4, EnumCreatureType.creature, BiomeGenBase.beach,BiomeGenBase.forest,BiomeGenBase.plains,CatBiome.INSTANCE);
       EntityRegistry.registerModEntity(entityclass, string, entityID, Catmod.instance,16,1,true);
   }
}
