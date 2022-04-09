package com.dimucathedev.shaftcraft;

import com.dimucathedev.shaftcraft.Registry.Blocks;
import com.dimucathedev.shaftcraft.Registry.Items;
import com.dimucathedev.shaftcraft.Registry.Sounds;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
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
    } //блоки предметы и прочая ХРЕНЬ
    public Main() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        init();
        MinecraftForge.EVENT_BUS.register(this);
    } // инит
    private void setup(final FMLCommonSetupEvent event){} //тоже какая то бесполезная хрень, сказали не убирать
}
