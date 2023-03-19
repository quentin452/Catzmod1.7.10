package fr.iamacat.catmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CatBlock extends Block {

    public CatBlock(Material material) {
        super(material);

        this.setHardness(5);//resistance to pickaxe
        this.setResistance(50);//resistance to tnt
    }
}