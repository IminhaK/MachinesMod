package bloop.machinemod.block.tile;

import bloop.machinemod.registry.CommonRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.math.BlockPos;

public class TileTick extends TileBase implements ITickableTileEntity {

    public TileTick() {
        super(CommonRegistry.tileTick);
    }

    @Override
    public void tick() {
        if(world.isRemote) {
            return;
        }

        BlockPos targetPos = this.pos.add(0, -2, 0);
        BlockState targetBlockState = world.getBlockState(targetPos);
        Block block = targetBlockState.getBlock();
        if(world.getTileEntity(targetPos) instanceof ITickableTileEntity) {
            ((ITickableTileEntity)world.getTileEntity(targetPos)).tick();
        } else if(block instanceof IGrowable && world.rand.nextInt(10) > 4) { //50% chance to grow (Still very fast)
            ((IGrowable)block).grow(world.getServer().getWorld(world.getDimensionKey()), world.rand, targetPos, targetBlockState);
        }
    }
}
