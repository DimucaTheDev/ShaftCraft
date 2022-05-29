package com.dimucathedev.shaftcraft.Registry;

import com.dimucathedev.shaftcraft.Blocks.Deco;
import com.dimucathedev.shaftcraft.Blocks.GraphiteOre;
import com.dimucathedev.shaftcraft.Main;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class Blocks {
    public static final DeferredRegister<Block> reg = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);

    public static final RegistryObject<Block> GRAPHITE_ORE = reg.register("graphite_ore", () -> new GraphiteOre(){
        @Override
        public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, @Nullable Direction direction) {
            return true;
        }
    });
    public static final RegistryObject<Block> TRAVERTINE_TILE = reg.register("travertine_tile", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND).requiresCorrectToolForDrops().strength(3.0F, 9.0F)));
    public static final RegistryObject<Block> BAUXITE_ORE = reg.register("bauxite_ore", () -> new GraphiteOre());
    public static final RegistryObject<Block> LIMONITE_ORE = reg.register("limonite_ore", () -> new GraphiteOre() {
        @Override
        public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {return 4;}

        @Override
        public void animateTick(BlockState p_49888_, Level p_49889_, BlockPos p_49890_, Random p_49891_) {

            BlockPos p_152432_ = p_49890_;
            Random r = new Random();
            if(r.nextInt(0,100)<10)
                for (int i = 0; i < r.nextInt(1,20); i++)
                    p_49889_.addParticle(ParticleTypes.ASH, p_152432_.getX()+r.nextFloat(0,1.3f),
                            p_152432_.getY()+0.3+r.nextFloat(0,1.3f),
                            p_152432_.getZ()+r.nextFloat(0,1.3f),
                            0,0,0);
            super.animateTick(p_49888_, p_49889_, p_49890_, p_49891_);
        }});
    public static final RegistryObject<Block> RUBY_ORE = reg.register("ruby_ore", () -> new GraphiteOre());
    public static final RegistryObject<Block> VOID_BLOCK = reg.register("void", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).noCollission().friction(1)));
    public static final RegistryObject<Block> DECO = reg.register("deco", () -> new Deco(Block.Properties.copy(LIMONITE_ORE.get())));
    public static final RegistryObject<Block> TRAVERTINE = reg.register("travertine", () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.ANDESITE)));
}
