package fr.iamacat.catmod.init;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.iamacat.catmod.Catmod;
import fr.iamacat.catmod.blocks.CatBlock;
import fr.iamacat.catmod.blocks.CatOre;
import fr.iamacat.catmod.blocks.CatTnt;
import fr.iamacat.catmod.blocks.CatTorch;
import fr.iamacat.catmod.entities.EntityCatTnt;
import fr.iamacat.catmod.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static fr.iamacat.catmod.init.RegisterItems.catIngot;

public class RegisterBlocks {
    public static Block catBlock,catTorch;//blocks
    public static Block catOre;//ores

    public static Block catTnt;//tnt

    public static void init() {
     catBlock = new CatBlock(Material.rock)
             .setBlockName("catBlock")
             .setCreativeTab(Catmod.catTab)
             .setBlockTextureName(Reference.MOD_ID + ":catBlock");
     catTorch = new CatTorch()
             .setBlockName("catTorch")
             .setCreativeTab(Catmod.catTab)
             .setBlockTextureName(Reference.MOD_ID + ":catTorch");
     catOre = new CatOre()
             .setBlockName("catOre")
             .setCreativeTab(Catmod.catTab)
             .setBlockTextureName(Reference.MOD_ID + ":cat_ore");
        catTnt = new CatTnt()
                .setCreativeTab(Catmod.catTab)
                .setBlockName("catTnt");
        }
    public static void register() {

        GameRegistry.registerBlock(catBlock, catBlock.getUnlocalizedName().substring(1));
        GameRegistry.addRecipe(new ItemStack(catBlock, 1),
                "OOO",
                        "OOO",
                        "OOO",
                'O', catIngot);
        GameRegistry.registerBlock(catTorch, catTorch.getUnlocalizedName().substring(5));
        GameRegistry.addRecipe(new ItemStack(catTorch, 1),
                "   ",
                        " O ",
                        " L ",
                'L', Items.stick,
                'O', RegisterItems.catCoin);
        ItemStack catIngotStack = new ItemStack(catIngot);
        GameRegistry.registerBlock(catOre, catOre.getUnlocalizedName().substring(5));
        OreDictionary.registerOre("oreCat", new ItemStack(catOre));
        // Smelting recipe for catIngot
        GameRegistry.addSmelting(RegisterBlocks.catOre, catIngotStack, 0.7f);

        GameRegistry.registerBlock(catTnt, catTnt.getUnlocalizedName().substring(5));
        GameRegistry.addRecipe(new ItemStack(catTnt, 2),
                "LWL",
                "OGO",
                "LWL",
                'L', RegisterItems.catGunpowder,
                'G', Items.diamond,
                'W', RegisterBlocks.catBlock,
                'O', Items.gunpowder);
        LanguageRegistry.instance().addStringLocalization("entity.catTNT.name", "Cat TNT");
    }
}


