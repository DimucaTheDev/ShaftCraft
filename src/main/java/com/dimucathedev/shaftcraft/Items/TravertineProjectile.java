package com.dimucathedev.shaftcraft.Items;

import com.dimucathedev.shaftcraft.Entities.TravertineEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SnowballItem;
import net.minecraft.world.level.Level;

public class TravertineProjectile extends Item {
    public TravertineProjectile(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) {
        ItemStack stack = p_41433_.getItemInHand(p_41434_);

        if (p_41432_.isClientSide()) {
            TravertineEntity e = new TravertineEntity(p_41432_,p_41433_);
            e.setItem(stack);
            e.shootFromRotation(p_41433_, p_41433_.getXRot(), p_41433_.getYRot(),0.0F, 1.5F, 1.0F);
            p_41432_.addFreshEntity(e);
        }
        return InteractionResultHolder.sidedSuccess(stack, p_41432_.isClientSide());
    }
}
