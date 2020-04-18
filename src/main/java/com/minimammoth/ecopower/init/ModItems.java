package com.minimammoth.ecopower.init;

import com.minimammoth.ecopower.EcoPower;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ObjectHolder(EcoPower.MOD_ID)
public class ModItems {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final Item PRISM = new BlockItem(ModBlocks.PRISM, new Item.Properties())
            .setRegistryName(ModBlocks.PRISM.getRegistryName());

    public static final Item MIRROW = new BlockItem(ModBlocks.MIRROW, new Item.Properties())
            .setRegistryName(ModBlocks.MIRROW.getRegistryName());

    @Mod.EventBusSubscriber(modid = EcoPower.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
            event.getRegistry().register(PRISM);
            event.getRegistry().register(MIRROW);
        }
    }
}
