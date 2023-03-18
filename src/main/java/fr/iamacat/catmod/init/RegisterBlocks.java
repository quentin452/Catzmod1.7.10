package fr.iamacat.catmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.catmod.Catmod;
import fr.iamacat.catmod.blocks.BlockBase;
import fr.iamacat.catmod.utils.CatTab;
import fr.iamacat.catmod.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RegisterBlocks {
    public static Block catBlock;
    public static void init() {
     catBlock = new BlockBase(Material.rock).setBlockName("catBlock").setCreativeTab(Catmod.catTab).setBlockTextureName(Reference.MOD_ID + ":catBlock");
    }
    public static void register() {
        GameRegistry.registerBlock(catBlock , catBlock.getUnlocalizedName().substring(5));
    }
}
