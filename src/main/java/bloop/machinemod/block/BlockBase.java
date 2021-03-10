package bloop.machinemod.block;

import bloop.machinemod.Jamm;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {

    public BlockBase(Material material, String name, float hardness) {
        super(AbstractBlock.Properties.create(material).sound(SoundType.STONE).hardnessAndResistance(hardness));
        setRegistryName(Jamm.MODID, name);
    }
}
