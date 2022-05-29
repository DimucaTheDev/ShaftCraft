package com.dimucathedev.shaftcraft.Blocks;

import com.dimucathedev.shaftcraft.Registry.Items.Items;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class Deco extends FallingBlock {
    public Deco(Properties p_49795_) {
        super(p_49795_);
    }
    @Override
    public void setPlacedBy(Level p_49847_, BlockPos p, BlockState p_49849_, @Nullable LivingEntity p_49850_, ItemStack p_49851_) {
        super.setPlacedBy(p_49847_, p, p_49849_, p_49850_, p_49851_);
    }
    @Override
    public InteractionResult use(BlockState p_60503_, Level p_60504_, BlockPos p_60505_, Player p_60506_, InteractionHand p_60507_, BlockHitResult p_60508_) {
        if(p_60504_.isClientSide)
        {
            if (p_60506_.getMainHandItem().getItem() == Items.RUBY.get())
            {
                if(!p_60506_.isCreative())
                    p_60506_.getMainHandItem().shrink(1);
                p_60506_.getInventory().add(new ItemStack(Items.SYNTHETIC_RUBY.get()));
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.SUCCESS;
    }

}
