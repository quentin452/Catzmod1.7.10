package fr.iamacat.catmod.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.catmod.items.CatIngot;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;

public class CatBlock extends Block {

    public CatBlock(Material rock) {
        super(rock);

        this.setHardness(2.0F);//resistance to pickaxe
        this.setResistance(15.0F);//resistance to tnt
        this.setHarvestLevel("pickaxe",3);
        // this.setLightLevel(14); how much the block will make light
        // this.setBlockUnbreakable();//make the block unbreakable
    }
}

//todo
  //  public void preInit() {
   //  CatBlock = new CatOre();
    //    GameRegistry.registerBlock(CatBlock, CatIngot.class, "CatBlock");
   //     CatIngot = new CatIngot(CatBlock);
   //     GameRegistry.registerItem(CatIngot, "CatIngot");
   //     OreDictionary.registerOre("CatOre", CatBlock);
