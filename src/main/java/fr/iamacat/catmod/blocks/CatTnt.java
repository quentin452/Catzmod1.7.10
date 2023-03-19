package fr.iamacat.catmod.blocks;

import fr.iamacat.catmod.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class CatTnt extends Block {
    private IIcon topIcon;
    private IIcon bottomIcon;
    private IIcon sideIcon;
    public CatTnt(Material tnt) {
        super(tnt);
        this.setBlockTextureName(Reference.MOD_ID + ":catTnt");
        this.setHardness(2.0F);//resistance to pickaxe
        this.setResistance(15.0F);//resistance to tnt
        // this.setHarvestLevel("pickaxe",3);
        // this.setLightLevel(14); how much the block will make light
        // this.setBlockUnbreakable();//make the block unbreakable
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
