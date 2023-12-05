package fr.iamacat.catmod.init;

import net.minecraftforge.common.DimensionManager;

import fr.iamacat.catmod.dimension.dimension1.WorldProviderCatDim1;

public class RegisterDimension {

    public static int DimensionID1 = 180;

    public static void init() {
        DimensionManager.registerProviderType(DimensionID1, WorldProviderCatDim1.class, false);
        DimensionManager.registerDimension(DimensionID1, DimensionID1);
    }
}
