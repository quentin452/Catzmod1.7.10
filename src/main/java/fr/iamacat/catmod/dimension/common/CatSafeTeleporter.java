package fr.iamacat.catmod.dimension.common;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class CatSafeTeleporter extends Teleporter {

    private WorldServer world;
    private World oldWorld;
    private Random random;
    private int newdim;

    public CatSafeTeleporter(final WorldServer par1WorldServer, final int dim, final World par2World) {
        super(par1WorldServer);
        this.world = par1WorldServer;
        this.oldWorld = par2World;
        this.random = new Random(par1WorldServer.getSeed());
        this.newdim = dim;
    }

    public void placeInPortal(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8) {
        this.justPutMe(par1Entity);
    }

    public boolean placeInExistingPortal(final Entity par1Entity, final double par2, final double par4,
        final double par6, final float par8) {
        this.justPutMe(par1Entity);
        return true;
    }

    public boolean makePortal(Entity p_85188_1_)
    {
        byte b0 = 16;
        double d0 = -1.0D;
        int i = MathHelper.floor_double(p_85188_1_.posX);
        int j = MathHelper.floor_double(p_85188_1_.posY);
        int k = MathHelper.floor_double(p_85188_1_.posZ);
        int l = i;
        int i1 = j;
        int j1 = k;
        int k1 = 0;
        int l1 = this.random.nextInt(4);
        int i2;
        double d1;
        int k2;
        double d2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        int l4;
        int i5;
        double d3;
        double d4;

        for (i2 = i - b0; i2 <= i + b0; ++i2)
        {
            d1 = (double)i2 + 0.5D - p_85188_1_.posX;

            for (k2 = k - b0; k2 <= k + b0; ++k2)
            {
                d2 = (double)k2 + 0.5D - p_85188_1_.posZ;
                label274:

                for (i3 = this.worldServerInstance.getActualHeight() - 1; i3 >= 0; --i3)
                {
                    if (this.worldServerInstance.isAirBlock(i2, i3, k2))
                    {
                        while (i3 > 0 && this.worldServerInstance.isAirBlock(i2, i3 - 1, k2))
                        {
                            --i3;
                        }

                        for (j3 = l1; j3 < l1 + 4; ++j3)
                        {
                            k3 = j3 % 2;
                            l3 = 1 - k3;

                            if (j3 % 4 >= 2)
                            {
                                k3 = -k3;
                                l3 = -l3;
                            }

                            for (i4 = 0; i4 < 3; ++i4)
                            {
                                for (j4 = 0; j4 < 4; ++j4)
                                {
                                    for (k4 = -1; k4 < 4; ++k4)
                                    {
                                        l4 = i2 + (j4 - 1) * k3 + i4 * l3;
                                        i5 = i3 + k4;
                                        int j5 = k2 + (j4 - 1) * l3 - i4 * k3;

                                        if (k4 < 0 && !this.worldServerInstance.getBlock(l4, i5, j5).getMaterial().isSolid() || k4 >= 0 && !this.worldServerInstance.isAirBlock(l4, i5, j5))
                                        {
                                            continue label274;
                                        }
                                    }
                                }
                            }

                            d3 = (double)i3 + 0.5D - p_85188_1_.posY;
                            d4 = d1 * d1 + d3 * d3 + d2 * d2;

                            if (d0 < 0.0D || d4 < d0)
                            {
                                d0 = d4;
                                l = i2;
                                i1 = i3;
                                j1 = k2;
                                k1 = j3 % 4;
                            }
                        }
                    }
                }
            }
        }

        if (d0 < 0.0D)
        {
            for (i2 = i - b0; i2 <= i + b0; ++i2)
            {
                d1 = (double)i2 + 0.5D - p_85188_1_.posX;

                for (k2 = k - b0; k2 <= k + b0; ++k2)
                {
                    d2 = (double)k2 + 0.5D - p_85188_1_.posZ;
                    label222:

                    for (i3 = this.worldServerInstance.getActualHeight() - 1; i3 >= 0; --i3)
                    {
                        if (this.worldServerInstance.isAirBlock(i2, i3, k2))
                        {
                            while (i3 > 0 && this.worldServerInstance.isAirBlock(i2, i3 - 1, k2))
                            {
                                --i3;
                            }

                            for (j3 = l1; j3 < l1 + 2; ++j3)
                            {
                                k3 = j3 % 2;
                                l3 = 1 - k3;

                                for (i4 = 0; i4 < 4; ++i4)
                                {
                                    for (j4 = -1; j4 < 4; ++j4)
                                    {
                                        k4 = i2 + (i4 - 1) * k3;
                                        l4 = i3 + j4;
                                        i5 = k2 + (i4 - 1) * l3;

                                        if (j4 < 0 && !this.worldServerInstance.getBlock(k4, l4, i5).getMaterial().isSolid() || j4 >= 0 && !this.worldServerInstance.isAirBlock(k4, l4, i5))
                                        {
                                            continue label222;
                                        }
                                    }
                                }

                                d3 = (double)i3 + 0.5D - p_85188_1_.posY;
                                d4 = d1 * d1 + d3 * d3 + d2 * d2;

                                if (d0 < 0.0D || d4 < d0)
                                {
                                    d0 = d4;
                                    l = i2;
                                    i1 = i3;
                                    j1 = k2;
                                    k1 = j3 % 2;
                                }
                            }
                        }
                    }
                }
            }
        }

        int k5 = l;
        int j2 = i1;
        k2 = j1;
        int l5 = k1 % 2;
        int l2 = 1 - l5;

        if (k1 % 4 >= 2)
        {
            l5 = -l5;
            l2 = -l2;
        }

        boolean flag;

        if (d0 < 0.0D)
        {
            if (i1 < 70)
            {
                i1 = 70;
            }

            if (i1 > this.worldServerInstance.getActualHeight() - 10)
            {
                i1 = this.worldServerInstance.getActualHeight() - 10;
            }

            j2 = i1;

            for (i3 = -1; i3 <= 1; ++i3)
            {
                for (j3 = 1; j3 < 3; ++j3)
                {
                    for (k3 = -1; k3 < 3; ++k3)
                    {
                        l3 = k5 + (j3 - 1) * l5 + i3 * l2;
                        i4 = j2 + k3;
                        j4 = k2 + (j3 - 1) * l2 - i3 * l5;
                        flag = k3 < 0;
                        this.worldServerInstance.setBlock(l3, i4, j4, flag ? Blocks.obsidian : Blocks.air);
                    }
                }
            }
        }

        for (i3 = 0; i3 < 4; ++i3)
        {
            for (j3 = 0; j3 < 4; ++j3)
            {
                for (k3 = -1; k3 < 4; ++k3)
                {
                    l3 = k5 + (j3 - 1) * l5;
                    i4 = j2 + k3;
                    j4 = k2 + (j3 - 1) * l2;
                    flag = j3 == 0 || j3 == 3 || k3 == -1 || k3 == 3;
                    this.worldServerInstance.setBlock(l3, i4, j4, (Block)(flag ? Blocks.obsidian : Blocks.portal), 0, 2);
                }
            }

            for (j3 = 0; j3 < 4; ++j3)
            {
                for (k3 = -1; k3 < 4; ++k3)
                {
                    l3 = k5 + (j3 - 1) * l5;
                    i4 = j2 + k3;
                    j4 = k2 + (j3 - 1) * l2;
                    this.worldServerInstance.notifyBlocksOfNeighborChange(l3, i4, j4, this.worldServerInstance.getBlock(l3, i4, j4));
                }
            }
        }

        return true;
    }

    private boolean isGroundBlock(final Block bid) {
        return bid != Blocks.air && (bid == Blocks.dirt || bid == Blocks.grass
            || bid == Blocks.stone
            || bid == Blocks.end_stone
            || bid == Blocks.netherrack
            || bid == Blocks.cobblestone
            || bid == Blocks.sand
            || bid == Blocks.sandstone
            || bid == Blocks.farmland);
    

    public void sendToThisDimension(final Entity e, final double newX, final double newY, final double newZ,
        final int ro) {
        if (this.oldWorld.isRemote) {
            return;
        }
        e.worldObj.removeEntity(e);
        e.isDead = false;
        e.setLocationAndAngles(newX, newY, newZ, (float) ro, 0.0f);
        final double motionX = 0.0;
        e.motionZ = motionX;
        e.motionY = motionX;
        e.motionX = motionX;
        e.setWorld((World) this.world);
        final Entity var6 = EntityList.createEntityByName(EntityList.getEntityString(e), (World) this.world);
        if (var6 != null) {
            var6.copyDataFrom(e, true);
            var6.setLocationAndAngles(newX, newY, newZ, (float) ro, 0.0f);
            final Entity entity = var6;
            final Entity entity2 = var6;
            final Entity entity3 = var6;
            final double motionX2 = 0.0;
            entity3.motionZ = motionX2;
            entity2.motionY = motionX2;
            entity.motionX = motionX2;
            var6.setWorld(this.world);
            this.world.spawnEntityInWorld(var6);
        }
        e.isDead = true;
    }

    public void removeStalePortalLocations(final long par1) {}
}
