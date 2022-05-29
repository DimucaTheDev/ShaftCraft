package com.dimucathedev.shaftcraft.Blocks;

import com.dimucathedev.shaftcraft.Entities.TravertinePieceEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class Test extends BlockItem {
    public Test(Block p_40565_, Properties p_40566_) {
        super(p_40565_, p_40566_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) {
        ItemStack stack = p_41433_.getItemInHand(p_41434_);
        if (!p_41432_.isClientSide()) {
            TravertinePieceEntity e = new TravertinePieceEntity(p_41432_,p_41433_);
            e.setItem(stack);
            e.shootFromRotation(p_41433_, p_41433_.getXRot(), p_41433_.getYRot(),1.0F, 1.5F, 1.0F);
            p_41432_.addFreshEntity(e);
        }
        if (!p_41433_.getAbilities().instabuild) {
            stack.shrink(1);
        }
        return InteractionResultHolder.sidedSuccess(stack, p_41432_.isClientSide());
    }
}
