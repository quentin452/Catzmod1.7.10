package fr.iamacat.catmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.catmod.Catmod;
import fr.iamacat.catmod.blocks.CatBlock;
import fr.iamacat.catmod.blocks.CatTorch;
import fr.iamacat.catmod.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RegisterBlocks {
    public static Block catBlock;//a normal block
    public static Block catTorch;//a torch
    public static void init() {
     catBlock = new CatBlock(Material.rock).setBlockName("catBlock").setCreativeTab(Catmod.catTab).setBlockTextureName(Reference.MOD_ID + ":catBlock");
     catTorch = new CatTorch().setBlockName("catTorch").setCreativeTab(Catmod.catTab).setBlockTextureName(Reference.MOD_ID + ":catTorch");
    }
    public static void register() {
        GameRegistry.registerBlock(catBlock, catBlock.getUnlocalizedName().substring(1));
        GameRegistry.addRecipe(new ItemStack(catBlock, 1),
                "OOO",
                "OOO",
                "OOO",
                'O', RegisterBlocks.catBlock);
        GameRegistry.registerBlock(catTorch, catTorch.getUnlocalizedName().substring(5));
        GameRegistry.addRecipe(new ItemStack(catTorch, 1),
                "   ",
                " O ",
                " L ",
                'L', Items.stick,
                'O', RegisterItems.catCoin);
    }
}
