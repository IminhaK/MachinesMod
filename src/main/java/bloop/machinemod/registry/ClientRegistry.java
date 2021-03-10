package bloop.machinemod.registry;

import bloop.machinemod.block.BlockBase;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientRegistry {

    private final IEventBus eventBus;

    public ClientRegistry(IEventBus eventBus) {
        this.eventBus = eventBus;
    }

    public static class ClientEvents {
        @SubscribeEvent
        public static void onClientSetupEvent(FMLClientSetupEvent event) {
            for (BlockBase b : CommonRegistry.blocks) {
                RenderTypeLookup.setRenderLayer(b, RenderType.getSolid());
            }
        }
    }

    public void registerClientEvents() {
        eventBus.register(ClientEvents.class);
    }
}
