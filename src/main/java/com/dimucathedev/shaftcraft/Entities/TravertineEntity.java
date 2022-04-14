package com.dimucathedev.shaftcraft.Entities;

import com.dimucathedev.shaftcraft.Items.TravertineProjectile;
import com.dimucathedev.shaftcraft.Registry.Blocks;
import com.dimucathedev.shaftcraft.Registry.Entities;
import com.dimucathedev.shaftcraft.Registry.Items;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;

public class TravertineEntity extends ThrowableItemProjectile {

    public TravertineEntity(EntityType<? extends ThrowableItemProjectile> type, Level world){
        super(type,world);
    }
    public TravertineEntity(EntityType<? extends ThrowableItemProjectile> entity, LivingEntity le, Level l){
        super(Entities.TRAVERTINE_PROJECTILE.get(),le,l);
    }
    public TravertineEntity(EntityType<? extends ThrowableItemProjectile> entity, double x,double y,double z, Level l){
        super(Entities.TRAVERTINE_PROJECTILE.get(),x,y,z,l);
    }
    public TravertineEntity(Level p_37399_, LivingEntity p_37400_) {
        super(Entities.TRAVERTINE_PROJECTILE.get(), p_37400_, p_37399_);
    }


    @Override
    protected Item getDefaultItem() {
        return Blocks.TRAVERTINE.get().asItem();
    }
    @Override
    protected void onHit(HitResult p_37260_) { this.kill();}
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
