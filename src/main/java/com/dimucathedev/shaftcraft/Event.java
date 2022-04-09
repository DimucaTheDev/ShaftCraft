package com.dimucathedev.shaftcraft;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.util.profiling.jfr.event.WorldLoadFinishedEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CommandBlock;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.logging.Logger;

@Mod.EventBusSubscriber
public class Event {

    @SubscribeEvent
    public static void onJoin(ClientPlayerNetworkEvent.LoggedInEvent event) {
        String cmd = "/give @p written_book{pages:['[\"\",{\"text\":\"      ShaftCraft\",\"bold\":true},{\"text\":\"\\\\n\\\\n1. \",\"color\":\"reset\"},{\"text\":\"Blocks\",\"bold\":true,\"italic\":true,\"underlined\":true,\"clickEvent\":{\"action\":\"change_page\",\"value\":2}},{\"text\":\"\\\\n2. \",\"color\":\"reset\"},{\"text\":\"Items\",\"bold\":true,\"italic\":true,\"underlined\":true,\"clickEvent\":{\"action\":\"change_page\",\"value\":3}},{\"text\":\"\\\\n3. \",\"color\":\"reset\"},{\"text\":\"Other hiden stuff\",\"bold\":true,\"italic\":true,\"underlined\":true,\"clickEvent\":{\"action\":\"change_page\",\"value\":4}},{\"text\":\"\\\\n\\\\n\\\\n\\\\n\\\\n\\\\n\\\\n\\\\n      by \",\"color\":\"reset\"},{\"text\":\"DimucaTheDev\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://vk.com/dimdima09\"}},{\"text\":\"\\\\n\\\\n\\\\n \"}]','{\"text\":\"\"}','{\"text\":\"\"}','{\"text\":\"\"}'],title:\"ShaftCraft FAQ\",author:DimucaTheDev,display:{Lore:[\"Small ShaftCraft FAQ, all items blocks and other stuff\"]}}";
        //Minecraft.getInstance().player.sendMessage(new TextComponent(cmd), null);
        ;
    }

}
