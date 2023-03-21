package fr.iamacat.catmod.handler;

import cpw.mods.fml.common.registry.EntityRegistry;
import fr.iamacat.catmod.Catmod;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import java.awt.*;
import java.util.Random;

public class EntityHandler
{
    public static void registerMonster(Class entityclass, String string){
        int entityID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(entityclass, string, EntityRegistry.findGlobalUniqueEntityId(), new Color(0, 221, 243).getRGB(), new Color(243, 0, 0).getRGB());// to make eggs for entities
        EntityRegistry.addSpawn(string, 100, 5,10, EnumCreatureType.monster, BiomeGenBase.beach,BiomeGenBase.desert,BiomeGenBase.forest,BiomeGenBase.plains);
        EntityRegistry.registerModEntity(entityclass, string, entityID, Catmod.instance,64,1,true);
    }
}
