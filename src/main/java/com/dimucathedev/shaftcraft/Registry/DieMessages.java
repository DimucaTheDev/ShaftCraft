package com.dimucathedev.shaftcraft.Registry;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.Entity;

import java.util.Random;

public class DieMessages {
    static Random r = new Random();
    public static final DamageSource wasKilledByStone(Entity e, Entity owner) // был закидан камнями до смерти
    {
        return e == owner ? new EntityDamageSource("stone_kill.self", owner) : new EntityDamageSource(r.nextDouble(10) > 5 ? "stone_kill.1" : "stone_kill.2", owner);
        //EDS, второй аргумент - тот кто кидал, не кого грохнули!
    }
}
