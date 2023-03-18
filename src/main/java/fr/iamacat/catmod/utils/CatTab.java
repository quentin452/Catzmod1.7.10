package fr.iamacat.catmod.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CatTab extends CreativeTabs {
    public CatTab(String l) {
        super(l);
    }
    @Override
    public Item getTabIconItem(){
        return Items.blaze_powder;
    }
}
