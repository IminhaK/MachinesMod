package bloop.machinemod;

import bloop.machinemod.block.BlockBase;
import bloop.machinemod.registry.ClientRegistry;
import bloop.machinemod.registry.CommonRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Jamm.MODID)
public class Jamm {

    public static final String MODID = "jamm";

    public Jamm() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final ClientRegistry clientRegistry = new ClientRegistry(modEventBus);

        CommonRegistry.addBlocks();
        modEventBus.register(CommonRegistry.class);
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> clientRegistry::registerClientEvents);
    }
}
