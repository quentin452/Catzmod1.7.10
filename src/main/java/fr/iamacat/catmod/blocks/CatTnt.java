package fr.iamacat.catmod.blocks;

import fr.iamacat.catmod.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.Explosion;
import net.minecraft.world.WorldServer;

public class CatTnt extends BlockTNT {
    private IIcon topIcon;
    private IIcon bottomIcon;
    private IIcon sideIcon;

    public CatTnt(Material tnt) {
        super();
        this.setHardness(2.0F);//resistance to pickaxe
        this.setResistance(15.0F);//resistance to tnt
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion) {
        if (!world.isRemote) {
            EntityTNTPrimed entity = new EntityTNTPrimed(world, x + 0.5, y + 0.5, z + 0.5, null);
            entity.fuse = world.rand.nextInt(entity.fuse / 4) + entity.fuse / 8;
            ((WorldServer)world).getEntityTracker().addEntityToTracker(entity);
        }
    }


    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.topIcon = iconRegister.registerIcon(Reference.MOD_ID + ":cat_tnt_top");
        this.bottomIcon = iconRegister.registerIcon(Reference.MOD_ID + ":cat_tnt_bottom");
        this.sideIcon = iconRegister.registerIcon(Reference.MOD_ID + ":cat_tnt_side");
    }

    @Override
    public IIcon getIcon(int side, int metadata) {
        if (side == 0) {
            return this.bottomIcon;
        } else if (side == 1) {
            return this.topIcon;
        } else {
            return this.sideIcon;
        }
    }
}