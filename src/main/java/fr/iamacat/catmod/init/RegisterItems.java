package fr.iamacat.catmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.catmod.tools.CatSword;
import fr.iamacat.catmod.tools.CatHoe;
import fr.iamacat.catmod.tools.CatPickaxe;
import fr.iamacat.catmod.tools.CatAxe;
import fr.iamacat.catmod.tools.CatShovel;
import fr.iamacat.catmod.utils.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import fr.iamacat.catmod.Catmod;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class RegisterItems {

    public static Item catCoin;
    public static Item catSword,catHoe,catPickaxe,catShovel,catAxe;

public static Item.ToolMaterial Cattools = EnumHelper.addToolMaterial("Cattools", 2,2000,6.0F,6.0F,30);
    public static void init() {
        catCoin = new Item().setUnlocalizedName("catCoin").setCreativeTab(Catmod.catTab).setTextureName(Reference.MOD_ID + ":catCoin");

        //Kit tools
        catSword = new CatSword(Cattools).setUnlocalizedName("catSword").setCreativeTab(Catmod.catTab).setTextureName(Reference.MOD_ID + ":catSword");
        catShovel = new CatShovel(Cattools).setUnlocalizedName("catShovel").setCreativeTab(Catmod.catTab).setTextureName(Reference.MOD_ID + ":catShovel");
        catPickaxe = new CatPickaxe(Cattools).setUnlocalizedName("catPickaxe").setCreativeTab(Catmod.catTab).setTextureName(Reference.MOD_ID + ":catPickaxe");
        catHoe = new CatHoe(Cattools).setUnlocalizedName("catHoe").setCreativeTab(Catmod.catTab).setTextureName(Reference.MOD_ID + ":catHoe");
        catAxe = new CatAxe(Cattools).setUnlocalizedName("catAxe").setCreativeTab(Catmod.catTab).setTextureName(Reference.MOD_ID + ":catAxe");
//add textures for kit tools
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
        int randomNumber = 5; // Change this to whatever number you want
        GameRegistry.addSmelting(Blocks.bedrock, itemTable, randomNumber);

        //Kit tools

        GameRegistry.registerItem(catSword,"catSword");
        GameRegistry.addRecipe(new ItemStack(catSword ,1),
                " O ",
                " O ",
                " L ",
                'L', Items.stick,
                'O', RegisterItems.catCoin);

        GameRegistry.registerItem(catPickaxe,"catPickaxe");
        GameRegistry.addRecipe(new ItemStack(catPickaxe ,1),
                "GGG",
                " L ",
                " L ",
                'L', Items.stick,
                'G', RegisterItems.catCoin);
        GameRegistry.registerItem(catShovel,"catShovel");
        GameRegistry.addRecipe(new ItemStack(catShovel ,1),
                " G ",
                " L ",
                " L ",
                'L', Items.stick,
                'G', RegisterItems.catCoin);
        GameRegistry.registerItem(catHoe,"catHoe");
        GameRegistry.addRecipe(new ItemStack(catHoe ,1),
                " GG",
                " L ",
                " L ",
                'L', Items.stick,
                'G', RegisterItems.catCoin);
        GameRegistry.registerItem(catHoe,"catHoe");
        GameRegistry.addRecipe(new ItemStack(catHoe ,1), // on onother side
                "GG ",
                " L ",
                " L ",
                'L', Items.stick,
                'G', RegisterItems.catCoin);
        GameRegistry.registerItem(catAxe,"catAxe");
        GameRegistry.addRecipe(new ItemStack(catAxe ,1),
                " GG",
                " LG",
                " L ",
                'L', Items.stick,
                'G', RegisterItems.catCoin);
        GameRegistry.registerItem(catAxe,"catAxe");
        GameRegistry.addRecipe(new ItemStack(catAxe ,1), // on onother side
                "GG ",
                "GL ",
                " L ",
                'L', Items.stick,
                'G', RegisterItems.catCoin);

    }
}
