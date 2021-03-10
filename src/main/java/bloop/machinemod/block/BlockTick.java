package bloop.machinemod.block;

import bloop.machinemod.block.tile.TileTick;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class BlockTick extends BlockBase {

    public BlockTick() {
        super(Material.ROCK, "tick", 2f);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileTick();
    }
}
