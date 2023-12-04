package fr.iamacat.catmod.utils;

import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import fr.iamacat.catmod.init.RegisterItems;

public class CatTabArmour extends CreativeTabs implements ITickable {

    private int tickCounter;
    private Item[] tabIcons; // Array to hold multiple tab icons
    private int currentIconIndex; // Index to keep track of the current tab icon

    public CatTabArmour(String label, Item[] icons) {
        super(label);
        this.tabIcons = icons;
        this.currentIconIndex = 0; // Start with the first icon in the array
        this.tickCounter = 0;
    }

    @Override
    public void tick() {
        if (tickCounter % 20 == 0) {
            changeTabIcon();
        }
        tickCounter++;
    }

    // Method to change the tab icon dynamically
    public void changeTabIcon() {
        if (tabIcons.length > 0) {
            currentIconIndex = (currentIconIndex + 1) % tabIcons.length;
        }
    }

    @Override
    public Item getTabIconItem() {
        if (tabIcons != null && tabIcons.length > 0 && tabIcons[currentIconIndex] != null) {
            return tabIcons[currentIconIndex];
        }
        return RegisterItems.cat_chestplate;
    }

    @Override
    public String getTranslatedTabLabel() {
        return "Cat Armour";
    }
}
