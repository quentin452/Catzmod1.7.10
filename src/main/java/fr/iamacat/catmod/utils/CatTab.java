package fr.iamacat.catmod.utils;

import fr.iamacat.catmod.init.RegisterItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CatTab extends CreativeTabs {
    public CatTab(String label) {
        super(label);
    }

    @Override
    public Item getTabIconItem() {
        return RegisterItems.catCoin;
    }

    @Override
    public String getTranslatedTabLabel() {
        return "CatMod"; // change this to the desired name of the creative tab
    }
}