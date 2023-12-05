package fr.iamacat.catmod.biomes.catbiome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenForest;

public class CatBiome extends BiomeGenForest {

    public static final CatBiome INSTANCE = new CatBiome(100);

    public CatBiome(int p_i45377_1_) {
        super(p_i45377_1_, 0);
        this.topBlock = Blocks.grass;
        this.fillerBlock = Blocks.stone;
        this.setBiomeName("Cat Biome");
        this.enableRain = false;
        this.enableSnow = false;
        this.waterColorMultiplier = 8336128;
        this.addDefaultFlowers();
    }
}
