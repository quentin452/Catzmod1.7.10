package fr.iamacat.catmod.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.world.World;

public class EntityCatTnt extends EntityTNTPrimed {

    public EntityCatTnt(World worldIn) {
        super(worldIn);
    }

    public EntityCatTnt(World worldIn, double x, double y, double z, EntityLivingBase igniter) {
        super(worldIn, x, y, z, igniter);
    }

    // Add any additional functionality here
}