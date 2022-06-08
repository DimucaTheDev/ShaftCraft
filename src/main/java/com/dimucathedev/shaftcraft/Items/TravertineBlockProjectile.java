package com.dimucathedev.shaftcraft.Items;

import com.dimucathedev.shaftcraft.Entities.TravertineBlockEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TravertineBlockProjectile extends BlockItem {
    public TravertineBlockProjectile(Block pp, Properties p_41383_) {
        super(pp, p_41383_);
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        p_41423_.add(Component.translatable("tooltip.travertine_throwable3"));
        p_41423_.add(Component.translatable("tooltip.travertine_throwable4"));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_43142_, Player p_43143_, InteractionHand p_43144_) {
        ItemStack stack = p_43143_.getItemInHand(p_43144_);
        if (!p_43142_.isClientSide()) {
            TravertineBlockEntity e = new TravertineBlockEntity(p_43142_,p_43143_);
            e.setItem(stack);
            e.shootFromRotation(p_43143_, p_43143_.getXRot(), p_43143_.getYRot(),1.0F, 1.5F, 1.0F);
            p_43142_.addFreshEntity(e);
        }
        if (!p_43143_.getAbilities().instabuild) {
            stack.shrink(1);
        }
        return InteractionResultHolder.sidedSuccess(stack, p_43142_.isClientSide());
    }
}
