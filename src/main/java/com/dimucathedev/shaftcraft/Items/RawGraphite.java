package com.dimucathedev.shaftcraft.Items;

import com.dimucathedev.shaftcraft.Registry.ItemTabs;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;

public class RawGraphite extends Item {
    public RawGraphite() {
        super(new Properties().tab(ItemTabs.tabMisc).fireResistant());
    }


/*    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        p_41423_.add(new TextComponent(ChatFormatting.GRAY+"Use Blast Furnace for smelting this item"));
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
    }*/
}
