package com.dimucathedev.shaftcraft.Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.Random;

public class GraphiteOre extends Block {
    public GraphiteOre() {
        super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F));
    }

    @Override
    public int getExpDrop(BlockState state, LevelReader level, RandomSource randomSource, BlockPos pos, int fortuneLevel, int silkTouchLevel) {
        Random r = new Random();
        return r.nextInt(1,2);
    }
/*
    @Override
    public void fallOn(Level p_152426_, BlockState p_152427_, BlockPos p_152428_, Entity p_152429_, float p_152430_) {
        p_152426_.addParticle(ParticleTypes.CLOUD, p_152428_.getX()+.5, p_152428_.getY()+1.5, p_152428_.getZ()+.5,0,0,0);
        super.fallOn(p_152426_, p_152427_, p_152428_, p_152429_, p_152430_);
    }*/
}
