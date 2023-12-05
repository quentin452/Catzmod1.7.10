package fr.iamacat.catmod.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import fr.iamacat.catmod.init.RegisterItems;

public class CatTabTools extends CreativeTabs {

    public CatTabTools(String label) {
        super(label);
    }

    @Override
    public Item getTabIconItem() {
        return RegisterItems.catSword;
    }

    @Override
    public String getTranslatedTabLabel() {
        return "Cat Tools"; // change this to the desired name of the creative tab // minecraft code colors :
                            // https://minecraft.fr/faq/code-couleur-minecraft/
    }
}
