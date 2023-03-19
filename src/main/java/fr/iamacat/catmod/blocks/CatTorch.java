package fr.iamacat.catmod.blocks;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;

public class CatTorch extends BlockTorch {


    public CatTorch() {

            this.setHardness(0);//resistance to pickaxe
            this.setResistance(50);//resistance to tnt
            this.setLightLevel(14);//how much the block will make light
            this.setStepSound(soundTypeWood);//sound when broken and placed
            //this.setLightOpacity(5);
        }
    }
