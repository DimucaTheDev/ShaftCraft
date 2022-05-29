package com.dimucathedev.shaftcraft;

import com.dimucathedev.shaftcraft.Registry.Entities;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Event {

    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Entities.TRAVERTINE_PROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(Entities.TRAVERTINE_PIECE_PROJECTILE.get(), ThrownItemRenderer::new);
    }
    //ИДИТЕ В КЛАСС МЕЙН ЗДЕСЬ НИЧЕ НЕ РОБИТ
}
