package bloop.machinemod.block.tile;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TileBase extends TileEntity {

    public TileBase(TileEntityType<? extends TileBase> tileType) {
        super(tileType);
    }
}
