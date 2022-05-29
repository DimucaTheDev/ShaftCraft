package com.dimucathedev.shaftcraft.Registry;

import com.dimucathedev.shaftcraft.Entities.TravertineBlockEntity;
import com.dimucathedev.shaftcraft.Entities.TravertinePieceEntity;
import com.dimucathedev.shaftcraft.Main;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Entities {
    public static DeferredRegister<EntityType<?>> reg = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MOD_ID);

    //SnowballItem
    public static final RegistryObject<EntityType<TravertinePieceEntity>> TRAVERTINE_PIECE_PROJECTILE = reg.register("travertine_piece_projectile",
            () -> EntityType.Builder.<TravertinePieceEntity>of(TravertinePieceEntity::new, MobCategory.MISC).fireImmune().sized(0.25f,0.25f).build("travertine_piece_projectile"));
    public static final RegistryObject<EntityType<TravertineBlockEntity>> TRAVERTINE_PROJECTILE = reg.register("travertine_projectile",
            () -> EntityType.Builder.<TravertineBlockEntity>of(TravertineBlockEntity::new, MobCategory.MISC).fireImmune().sized(10,10).build("travertine_projectile")); //0.25f

}
