package fr.iamacat.catmod.biomes.catbiome;

import fr.iamacat.catmod.init.RegisterBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class CatBiome extends BiomeGenBase {
    public static final CatBiome INSTANCE = new CatBiome(100); // declare the biome instance as a static variable
    public CatBiome(int p_i1971_1_) {
        super(p_i1971_1_);
        this.topBlock = RegisterBlocks.catBlock;
        this.fillerBlock = Blocks.stone;
        this.setBiomeName("Cat Biome"); // set the name of the biome
    }
}
