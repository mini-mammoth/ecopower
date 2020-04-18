package com.minimammoth.ecopower.init;

import com.minimammoth.ecopower.EcoPower;
import com.minimammoth.ecopower.block.MirrorBlock;
import com.minimammoth.ecopower.block.PrismBlock;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ObjectHolder(EcoPower.MOD_ID)
public class ModBlocks {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final PrismBlock PRISM = new PrismBlock();
    public static final MirrorBlock MIRROW = new MirrorBlock();

    @Mod.EventBusSubscriber(modid = EcoPower.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");

            blockRegistryEvent.getRegistry().register(PRISM);
            blockRegistryEvent.getRegistry().register(MIRROW);
        }
    }
}
