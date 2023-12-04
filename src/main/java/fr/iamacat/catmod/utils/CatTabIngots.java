package fr.iamacat.catmod.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import fr.iamacat.catmod.init.RegisterItems;

public class CatTabIngots extends CreativeTabs {

    public CatTabIngots(String label) {
        super(label);
    }

    @Override
    public Item getTabIconItem() {
        return RegisterItems.catIngot;
    }

    @Override
    public String getTranslatedTabLabel() {
        return "Cat Ingots"; // change this to the desired name of the creative tab // minecraft code colors :
                             // https://minecraft.fr/faq/code-couleur-minecraft/
    }
}
