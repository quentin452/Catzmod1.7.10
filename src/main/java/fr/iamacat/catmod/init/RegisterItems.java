package fr.iamacat.catmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.catmod.utils.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import fr.iamacat.catmod.Catmod;
import net.minecraft.item.ItemStack;

public class RegisterItems {
    public static Item catCoin;

    public static void init() {
        catCoin = new Item().setUnlocalizedName("catCoin").setCreativeTab(Catmod.catTab).setTextureName(Reference.MOD_ID + ":catCoin");
        }

    public static void register(){
        GameRegistry.registerItem(catCoin,"catCoin");

        // Shapeless crafting recipe for catCoin
        ItemStack itemTable = new ItemStack(catCoin);
        GameRegistry.addShapelessRecipe(itemTable,
                Items.nether_star,
                Blocks.dragon_egg,
                Blocks.end_portal_frame,
                Blocks.end_portal_frame,
                Blocks.end_portal_frame);
        // Smelting recipe for catCoin
        int randomNumber = 9; // Change this to whatever number you want
        GameRegistry.addSmelting(Blocks.bedrock, itemTable, randomNumber);
    }
}
