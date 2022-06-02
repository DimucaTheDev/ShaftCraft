package com.dimucathedev.shaftcraft;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID)
public class Event {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {

    }
}
