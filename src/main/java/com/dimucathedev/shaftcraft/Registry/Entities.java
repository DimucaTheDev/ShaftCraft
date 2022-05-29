package com.dimucathedev.shaftcraft.Registry;

import com.dimucathedev.shaftcraft.Entities.TravertineEntity;
import com.dimucathedev.shaftcraft.Main;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.SnowballItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Entities {
    public static DeferredRegister<EntityType<?>> reg = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MOD_ID);

    //SnowballItem
    public static final RegistryObject<EntityType<TravertineEntity>> TRAVERTINE_PROJECTILE = reg.register("travertine_projectile",
            () -> EntityType.Builder.<TravertineEntity>of(TravertineEntity::new, MobCategory.MISC).sized(0.25f,0.25f).build("travertine_projectile"));
}
