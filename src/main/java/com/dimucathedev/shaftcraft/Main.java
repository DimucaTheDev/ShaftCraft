package com.dimucathedev.shaftcraft;

import com.dimucathedev.shaftcraft.Registry.Blocks;
import com.dimucathedev.shaftcraft.Registry.Entities;
import com.dimucathedev.shaftcraft.Registry.Items.Items;
import com.dimucathedev.shaftcraft.Registry.Sounds;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("shaftcraft")
public class Main
{
    private static final Logger LOGGER = LogManager.getLogger(); //Бесполезная хрень
    public static final String MOD_ID = "shaftcraft"; //АйДи мода
    public static void init(){
        Items.reg.register(FMLJavaModLoadingContext.get().getModEventBus());
        Sounds.reg.register(FMLJavaModLoadingContext.get().getModEventBus());
        Blocks.reg.register(FMLJavaModLoadingContext.get().getModEventBus());
        Entities.reg.register(FMLJavaModLoadingContext.get().getModEventBus());
    } //блоки предметы и прочая ХРЕНЬ
    public Main() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        init();
        MinecraftForge.EVENT_BUS.register(this);
    } // инит
    private void setup(final FMLCommonSetupEvent event)
    {
        EntityRenderers.register(Entities.TRAVERTINE_PROJECTILE.get(), ThrownItemRenderer::new);
        EntityRenderers.register(Entities.TRAVERTINE_PIECE_PROJECTILE.get(), ThrownItemRenderer::new);
    } //Регистрация модельки ентити
    private void clientSetup(FMLClientSetupEvent client){}
}
