package fr.iamacat.catmod.blocks;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;

public class CatTorch extends BlockTorch {

    public CatTorch(Material rock) {

        this.setHardness(1);//resistance to pickaxe
        this.setResistance(50);//resistance to tnt
        this.setLightLevel(8);//how much the block will make light
    }
}
