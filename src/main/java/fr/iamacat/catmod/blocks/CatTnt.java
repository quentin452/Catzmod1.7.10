// needed to make a custom tnt(the block)
package fr.iamacat.catmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.catmod.entities.tnt.EntityCatTnt;
import fr.iamacat.catmod.utils.Reference;

public class CatTnt extends BlockTNT {

    @SideOnly(Side.CLIENT)
    private IIcon topIcon;
    @SideOnly(Side.CLIENT)
    private IIcon bottomIcon;
    @SideOnly(Side.CLIENT)
    private IIcon sideIcon;

    public CatTnt() {
        super();
        this.setHardness(0.0F);
        this.setResistance(0.0F);
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side == 0) {
            return bottomIcon;
        } else if (side == 1) {
            return topIcon;
        } else {
            return sideIcon;
        }
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World worldIn, int x, int y, int z) {
        super.onBlockAdded(worldIn, x, y, z);

        if (worldIn.isBlockIndirectlyGettingPowered(x, y, z)) {
            this.onBlockDestroyedByPlayer(worldIn, x, y, z, 1);
            worldIn.setBlockToAir(x, y, z);
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    public void onNeighborBlockChange(World worldIn, int x, int y, int z, Block neighbor) {
        if (worldIn.isBlockIndirectlyGettingPowered(x, y, z)) {
            this.onBlockDestroyedByPlayer(worldIn, x, y, z, 1);
            worldIn.setBlockToAir(x, y, z);
        }
    }

    /**
     * Called upon the block being destroyed by an explosion
     */
    public void onBlockDestroyedByExplosion(World worldIn, int x, int y, int z, Explosion explosionIn) {
        if (!worldIn.isRemote) {
            EntityCatTnt entityTNT = new EntityCatTnt(
                worldIn,
                x + 0.5,
                y + 0.5,
                z + 0.5,
                explosionIn.getExplosivePlacedBy());

            // Setting the fuse time in ticks for 22 seconds
            entityTNT.fuse = 22 * 20;

            worldIn.spawnEntityInWorld(entityTNT);

        }
    }

    /**
     * Called right before the block is destroyed by a player. Args: world, x, y, z, metaData
     */
    public void onBlockDestroyedByPlayer(World worldIn, int x, int y, int z, int meta) {
        this.func_150114_a(worldIn, x, y, z, meta, null);
    }

    public void func_150114_a(World p_150114_1_, int p_150114_2_, int p_150114_3_, int p_150114_4_, int p_150114_5_,
        EntityLivingBase p_150114_6_) {
        if (!p_150114_1_.isRemote && ((p_150114_5_ & 1) == 1)) {
            EntityCatTnt entitytntprimed = new EntityCatTnt(
                p_150114_1_,
                (float) p_150114_2_ + 0.5F,
                (float) p_150114_3_ + 0.5F,
                (float) p_150114_4_ + 0.5F,
                p_150114_6_);
            p_150114_1_.spawnEntityInWorld(entitytntprimed);
            p_150114_1_.playSoundAtEntity(entitytntprimed, Reference.MOD_ID + ":tntIgnate", 1.0F, 1.0F);

        }
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World worldIn, int x, int y, int z, EntityPlayer player, int side, float subX,
        float subY, float subZ) {
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem()
            .getItem() == Items.flint_and_steel) {
            this.func_150114_a(worldIn, x, y, z, 1, player);
            worldIn.setBlockToAir(x, y, z);
            player.getCurrentEquippedItem()
                .damageItem(1, player);
            return true;
        } else {
            return super.onBlockActivated(worldIn, x, y, z, player, side, subX, subY, subZ);
        }
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World worldIn, int x, int y, int z, Entity entityIn) {
        if (entityIn instanceof EntityArrow && !worldIn.isRemote) {
            EntityArrow entityarrow = (EntityArrow) entityIn;

            if (entityarrow.isBurning()) {
                this.func_150114_a(
                    worldIn,
                    x,
                    y,
                    z,
                    1,
                    entityarrow.shootingEntity instanceof EntityLivingBase
                        ? (EntityLivingBase) entityarrow.shootingEntity
                        : null);
                worldIn.setBlockToAir(x, y, z);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.topIcon = iconRegister.registerIcon(Reference.MOD_ID + ":cat_tnt_top");
        this.bottomIcon = iconRegister.registerIcon(Reference.MOD_ID + ":cat_tnt_bottom");
        this.sideIcon = iconRegister.registerIcon(Reference.MOD_ID + ":cat_tnt_side");
    }
}
