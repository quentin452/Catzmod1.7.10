package fr.iamacat.catmod.init;

import static fr.iamacat.catmod.init.RegisterItems.catIngot;
import static fr.iamacat.catmod.init.RegisterItems.catStick;
import static net.minecraft.block.material.Material.rock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.catmod.Catmod;
import fr.iamacat.catmod.blocks.*;
import fr.iamacat.catmod.utils.Reference;

public class RegisterBlocks {

    // blocks
    public static Block catBlock, catTorch, catStairs, catFence, catTnt, catOre;

    public static void init() {
        catBlock = new CatBlock(rock).setBlockName("catBlock")
            .setCreativeTab(Catmod.catTab2)
            .setBlockTextureName(Reference.MOD_ID + ":catBlock");
        catTorch = new CatTorch().setBlockName("catTorch")
            .setCreativeTab(Catmod.catTab2)
            .setBlockTextureName(Reference.MOD_ID + ":catTorch");
        catOre = new CatOre().setBlockName("catOre")
            .setCreativeTab(Catmod.catTab2)
            .setBlockTextureName(Reference.MOD_ID + ":cat_ore");

        catStairs = new CatStairs(RegisterBlocks.catBlock, 0).setBlockName("catStairs")
            .setCreativeTab(Catmod.catTab2);
        catTnt = new CatTnt().setCreativeTab(Catmod.catTab5)
            .setBlockName("catTnt")
            .setStepSound(Block.soundTypeGrass);
        // .setBlockTextureName(RefStrings.MODID + ":tnt")
        catFence = new CatFence(Reference.MOD_ID + ":catBlock", Material.rock).setBlockName("catFence")
            .setCreativeTab(Catmod.catTab2);
    }

    public static void register() {
        // register names

        GameRegistry.registerBlock(
            catStairs,
            catStairs.getUnlocalizedName()
                .substring(5));
        GameRegistry.registerBlock(
            catBlock,
            catBlock.getUnlocalizedName()
                .substring(1));
        GameRegistry.registerBlock(
            catFence,
            catFence.getUnlocalizedName()
                .substring(5));
        GameRegistry.registerBlock(
            catTorch,
            catTorch.getUnlocalizedName()
                .substring(5));
        GameRegistry.registerBlock(
            catOre,
            catOre.getUnlocalizedName()
                .substring(5));
        GameRegistry.registerBlock(
            catTnt,
            catTnt.getUnlocalizedName()
                .substring(5));

        // register recipes
        GameRegistry.addRecipe(new ItemStack(catBlock, 1), "OOO", "OOO", "OOO", 'O', catIngot);
        GameRegistry.addShapelessRecipe(new ItemStack(catTorch, 1), catStick, RegisterItems.catCoin);
        ItemStack catIngotStack = new ItemStack(catIngot);
        OreDictionary.registerOre("oreCat", new ItemStack(catOre));
        // Smelting recipe for catIngot
        GameRegistry.addSmelting(RegisterBlocks.catOre, catIngotStack, 0.7f);
        GameRegistry.addRecipe(
            new ItemStack(catTnt, 2),
            "LWL",
            "OGO",
            "LWL",
            'L',
            RegisterItems.catGunpowder, 'G',
            Items.diamond, 'W',
            RegisterBlocks.catBlock, 'O',
            Items.gunpowder);
        GameRegistry.addRecipe(
            new ItemStack(catStairs, 6), // 6 = number of blocks gived by the recipe
            "L  ",
                    "LL ",
                    "LLL",
                    'L',
            RegisterBlocks.catBlock);
    }
}
