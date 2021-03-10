package bloop.machinemod.registry;

import bloop.machinemod.Jamm;
import bloop.machinemod.block.BlockBase;
import bloop.machinemod.block.BlockTick;
import bloop.machinemod.block.tile.TileBase;
import bloop.machinemod.block.tile.TileTick;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

public class CommonRegistry {

    public static List<BlockBase> blocks = new ArrayList<>();

    public static void addBlocks() {
        blocks.add(new BlockTick());
    }

    @SubscribeEvent
    public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
        for(BlockBase b : blocks) {
            blockRegisterEvent.getRegistry().register(b);
        }
    }

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {

        /*ForgeRegistries.BLOCKS.register(this);

        Item.Properties itemProperties = new Item.Properties()
                .maxStackSize(64)
                .group(ItemGroup.MISC);
        ForgeRegistries.ITEMS.register(new BlockItem(this, itemProperties).setRegistryName(name));*/
        for(BlockBase b : blocks) {
            Item.Properties itemProperties = new Item.Properties()
                    .maxStackSize(64)
                    .group(ItemGroup.MISC);
            itemRegisterEvent.getRegistry().register(new BlockItem(b, itemProperties).setRegistryName(b.getRegistryName()));
        }
    }

    public static TileEntityType<TileTick> tileTick;

    @SubscribeEvent
    public static void onTileEntityTypeRegistration(final RegistryEvent.Register<TileEntityType<?>> event) {
        tileTick = TileEntityType.Builder.create(TileTick::new, blocks.get(0)).build(null);
        tileTick.setRegistryName(Jamm.MODID + ":tile_tick");

        event.getRegistry().register(tileTick);
    }
}
