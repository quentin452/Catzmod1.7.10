package fr.iamacat.catmod.entities;

import cpw.mods.fml.common.registry.EntityRegistry;
import fr.iamacat.catmod.Catmod;
import fr.iamacat.catmod.blocks.CatTnt;
import fr.iamacat.catmod.utils.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityCatTnt extends EntityTNTPrimed {

    public EntityCatTnt(World world) {
        super(world);
    }

    public EntityCatTnt(World worldIn, double x, double y, double z, EntityLivingBase igniter, Catmod modInstance) {
        super(worldIn, x, y, z, igniter);
        int entityID = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(EntityCatTnt.class, "EntityCatTnt", entityID);
        EntityRegistry.registerModEntity(EntityCatTnt.class, "EntityCatTnt", entityID, EntityTntInstance.Instance, 64, 10, true);
    }

    // Add any additional functionality here

    public static class EntityTntInstance {
        public static final EntityTntInstance Instance = new EntityTntInstance();

        private EntityTntInstance() {}

        public void registerEntity() {
            EntityRegistry.registerGlobalEntityID(EntityCatTnt.class, "EntityCatTnt", EntityRegistry.findGlobalUniqueEntityId());


        }
    }

}
