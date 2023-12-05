package fr.iamacat.catmod.init;

import net.minecraftforge.common.BiomeManager;

import fr.iamacat.catmod.biomes.catbiome.CatBiome;

public class RegisterBiomes {

    public static void init() {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(CatBiome.INSTANCE, 10));
    }
}
