package com.dimucathedev.shaftcraft.Items;

import com.dimucathedev.shaftcraft.Registry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RawGraphite extends Item {
    public RawGraphite() {
        super(new Properties().tab(Registry.tabMisc).fireResistant());
    }

/*    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        p_41423_.add(new TextComponent(ChatFormatting.GRAY+"Use Blast Furnace for smelting this item"));
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
    }*/
}
