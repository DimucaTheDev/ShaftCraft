package com.dimucathedev.shaftcraft.Entities;

import com.dimucathedev.shaftcraft.Registry.DieMessages;
import com.dimucathedev.shaftcraft.Registry.Entities;
import com.dimucathedev.shaftcraft.Registry.Items.Items;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;

import java.util.Random;

public class TravertinePieceEntity extends ThrowableItemProjectile {

    public TravertinePieceEntity(EntityType<? extends TravertinePieceEntity> p_37391_, Level p_37392_) {
        super(p_37391_, p_37392_);
    }
    public TravertinePieceEntity(Level p_37399_, LivingEntity p_37400_) {
        super(Entities.TRAVERTINE_PIECE_PROJECTILE.get(), p_37400_, p_37399_);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.TRAVERTINE_PIECE.get();
    }
    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItemRaw();
        return itemstack.isEmpty() ? new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(Items.TRAVERTINE_BLOCK_ITEM.get())) : new ItemParticleOption(ParticleTypes.ITEM, itemstack);
    }    @Override
    public void handleEntityEvent(byte p_37402_) {
        if (p_37402_ == 3) {
            ParticleOptions particleoptions = this.getParticle();

            for(int i = 0; i < 8; ++i) {
                this.level.addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }
    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
    @Override
    protected void onHit(HitResult p_37260_) {
        handleEntityEvent((byte)3);
        Random r = new Random();
        if (p_37260_.getType() == HitResult.Type.ENTITY){
            Entity e = ((EntityHitResult)p_37260_).getEntity();
            e.hurt(DieMessages.wasKilledByStone(((EntityHitResult)p_37260_).getEntity(), getOwner()), r.nextInt(5));
            kill();
            return;
        }

        var pos = new BlockPos(p_37260_.getLocation().x, p_37260_.getLocation().y, p_37260_.getLocation().z);
        int a = count(level.getBlockState(pos).getBlock().getName().toString(), "glass");
        if (a > 0) {
            level.destroyBlock(pos, false);
        }
        else {
            if(r.nextDouble(10) > 6)
            //if(!((Player)getOwner()).getAbilities().instabuild)
                    spawnSelf(p_37260_);
            else kill();
        }

    }
    public void spawnSelf(HitResult p_37260_){
        ItemEntity entity = new ItemEntity(level, p_37260_.getLocation().x,p_37260_.getLocation().y,p_37260_.getLocation().z,new ItemStack(Items.TRAVERTINE_PIECE.get()));
        level.addFreshEntity(entity);
        kill();
    }
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
