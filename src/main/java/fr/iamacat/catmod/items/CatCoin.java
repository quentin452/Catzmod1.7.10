package fr.iamacat.catmod.items;

import net.minecraft.item.Item;
import net.minecraft.potion.PotionHelper;

public class CatCoin extends Item {
        public CatCoin() {
           this.setFull3D();
           this.setMaxDamage(1);
           this.setPotionEffect(PotionHelper.blazePowderEffect);
        }
}
