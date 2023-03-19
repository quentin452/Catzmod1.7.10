package fr.iamacat.catmod.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.catmod.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class CatTnt extends BlockTNT {

    private IIcon topIcon;
    private IIcon bottomIcon;
    private IIcon sideIcon;

    public CatTnt(Material tnt) {
        super();
        this.setHardness(2.0F);
        this.setResistance(0.0F);
        this.setBlockName("catTnt");
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            EntityTNTPrimed entity = new EntityTNTPrimed(world, x + 0.5, y + 0.5, z + 0.5, player);
            entity.fuse = 80; // set the fuse to 80 ticks (4 seconds)
            world.spawnEntityInWorld(entity); // spawn the primed TNT entity in the world
            world.playSoundAtEntity(entity, "game.tnt.primed", 1.0F, 1.0F);
            player.inventory.decrStackSize(player.inventory.currentItem, 1); // remove one item from the player's inventory
            return true;
        }
        return false;
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

    @Override
    public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion) {
        if (!world.isRemote) {
            EntityTNTPrimed entity = new EntityTNTPrimed(world, x + 0.5, y + 0.5, z + 0.5, null);
            entity.fuse = 80;
            world.spawnEntityInWorld(entity);
        }
    }
}
