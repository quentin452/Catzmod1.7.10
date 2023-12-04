package fr.iamacat.catmod.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import fr.iamacat.catmod.init.RegisterItems;

public class CatTabBlocks extends CreativeTabs {

    public CatTabBlocks(String label) {
        super(label);
    }

    @Override
    public Item getTabIconItem() {
        return RegisterItems.catCoin;
    } // Suppost to be a catBlock

    @Override
    public String getTranslatedTabLabel() {
        return "Cat Blocks"; // change this to the desired name of the creative tab // minecraft code colors :
                             // https://minecraft.fr/faq/code-couleur-minecraft/
    }
}
