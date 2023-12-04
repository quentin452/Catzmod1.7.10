package fr.iamacat.catmod.dimension.dimension1;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderCatDim1 extends WorldProvider {

    public String getDimensionName() {
        return "Cat Dimension 1";
    }

    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderCatDim1(this.worldObj, this.worldObj.getSeed(), true);
    }
}
