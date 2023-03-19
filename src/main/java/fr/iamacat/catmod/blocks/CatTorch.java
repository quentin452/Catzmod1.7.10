package fr.iamacat.catmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.world.World;

public class CatTorch extends BlockTorch {

    public CatTorch() {
        super();
        this.setHardness(0.0F);
        this.setLightLevel(1.0F);
        this.setStepSound(soundTypeWood);
        this.setTickRandomly(true);
        this.setLightOpacity(0);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }

    private void setDefaultDirection(World world, int x, int y, int z) {
        if (!world.isRemote) {
            Block block1 = world.getBlock(x, y, z - 1);
            Block block2 = world.getBlock(x, y, z + 1);
            Block block3 = world.getBlock(x - 1, y, z);
            Block block4 = world.getBlock(x + 1, y, z);

            byte meta = 0;

            if (block1.isOpaqueCube() && !block2.isOpaqueCube()) {
                meta = 0;
            }

            if (block2.isOpaqueCube() && !block1.isOpaqueCube()) {
                meta = 1;
            }

            if (block3.isOpaqueCube() && !block4.isOpaqueCube()) {
                meta = 2;
            }

            if (block4.isOpaqueCube() && !block3.isOpaqueCube()) {
                meta = 3;
            }

            world.setBlockMetadataWithNotify(x, y, z, meta, 2);
        }
    }
}