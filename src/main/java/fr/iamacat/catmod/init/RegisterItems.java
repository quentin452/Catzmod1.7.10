package fr.iamacat.catmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.catmod.tools.*;
import fr.iamacat.catmod.utils.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import fr.iamacat.catmod.Catmod;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class RegisterItems {

    //items
    public static Item catCoin,catStick;
    //tools
    public static Item catSword,catHoe,catPickaxe,catShovel,catAxe;
    //armor
    public static Item cat_boots,cat_chestplate,cat_helmet,cat_leggings;

    public static Item.ToolMaterial CAT_TOOLS_MATERIAL = EnumHelper.addToolMaterial("Cattools", 2,2000,6.0F,6.0F,30);
    public static final ItemArmor.ArmorMaterial CAT_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("CatArmors", 2000, new int[]{2, 7, 5, 3}, 30);

    public static void init() {
        catCoin = new Item().setUnlocalizedName("catCoin").setCreativeTab(Catmod.catTab).setTextureName(Reference.MOD_ID + ":catCoin");
        catStick = new Item().setUnlocalizedName("catStick").setCreativeTab(Catmod.catTab).setTextureName(Reference.MOD_ID + ":catStick");

        //Kit Armors
        cat_helmet = new ItemArmor(CAT_ARMOR_MATERIAL,0,0).setUnlocalizedName("cat_helmet").setCreativeTab(Catmod.catTab).setTextureName(Reference.MOD_ID + ":cat_helmet");
        cat_chestplate = new ItemArmor(CAT_ARMOR_MATERIAL,0,1).setUnlocalizedName("cat_chestplate").setCreativeTab(Catmod.catTab).setTextureName(Reference.MOD_ID + ":cat_chestplate");
        cat_leggings = new ItemArmor(CAT_ARMOR_MATERIAL,0,2).setUnlocalizedName("cat_leggings").setCreativeTab(Catmod.catTab).setTextureName(Reference.MOD_ID + ":cat_leggings");
        cat_boots = new ItemArmor(CAT_ARMOR_MATERIAL,0, 3).setUnlocalizedName("cat_boots").setCreativeTab(Catmod.catTab).setTextureName(Reference.MOD_ID + ":cat_boots");

        //Kit tools
        catSword = new CatSword(CAT_TOOLS_MATERIAL).setUnlocalizedName("catSword").setCreativeTab(Catmod.catTab).setTextureName(Reference.MOD_ID + ":catSword");
        catShovel = new CatShovel(CAT_TOOLS_MATERIAL).setUnlocalizedName("catShovel").setCreativeTab(Catmod.catTab).setTextureName(Reference.MOD_ID + ":catShovel");
        catPickaxe = new CatPickaxe(CAT_TOOLS_MATERIAL).setUnlocalizedName("catPickaxe").setCreativeTab(Catmod.catTab).setTextureName(Reference.MOD_ID + ":catPickaxe");
        catHoe = new CatHoe(CAT_TOOLS_MATERIAL).setUnlocalizedName("catHoe").setCreativeTab(Catmod.catTab).setTextureName(Reference.MOD_ID + ":catHoe");
        catAxe = new CatAxe(CAT_TOOLS_MATERIAL).setUnlocalizedName("catAxe").setCreativeTab(Catmod.catTab).setTextureName(Reference.MOD_ID + ":catAxe");
}

//register items/blocks + make recipes
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
        GameRegistry.addRecipe(new ItemStack(catAxe ,1), // on onother side
                "GG ",
                "GL ",
                " L ",
                'L', Items.stick,
                'G', RegisterItems.catCoin);

        GameRegistry.registerItem(catStick,"catStick");

        // Shapeless crafting recipe for catCoin
        ItemStack itemCatStick = new ItemStack(catStick);
        GameRegistry.addShapelessRecipe(itemCatStick,
                RegisterItems.catCoin,
                RegisterItems.catCoin);

        //Kit Armors
// Cat Helmet
        GameRegistry.registerItem(cat_helmet,"cat_helmet");
        GameRegistry.addRecipe(new ItemStack(cat_helmet ,1),
                "GGG",
                "G G",
                "H H",
                'G', RegisterItems.catCoin,
                'H', RegisterItems.catStick);
// Cat Chestplate
        GameRegistry.registerItem(cat_chestplate,"cat_chestplate");
        GameRegistry.addRecipe(new ItemStack(cat_chestplate ,1),
                "GHG",
                "GGG",
                "GGG",
                'G', RegisterItems.catCoin,
                'H', RegisterItems.catStick);
// Cat Leggings
        GameRegistry.registerItem(cat_leggings,"cat_leggings");
        GameRegistry.addRecipe(new ItemStack(cat_leggings ,1),
                "GGG",
                "GHG",
                "GHG",
                'G', RegisterItems.catCoin,
                'H', RegisterItems.catStick);
// Cat Boots
        GameRegistry.registerItem(cat_boots,"cat_boots");
        GameRegistry.addRecipe(new ItemStack(cat_boots ,1),
                "H H",
                "G G",
                "G G",
                'G', RegisterItems.catCoin,
                'H', RegisterItems.catStick);

    }
}
