package com.dimucathedev.shaftcraft.Blocks;

import com.dimucathedev.shaftcraft.Registry;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropperBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

import static net.minecraft.world.phys.shapes.Shapes.join;

public class DecoCrafter extends DropperBlock {

    public DecoCrafter() {
        super(Properties.copy(Registry.LIMONITE_ORE.get()));
        this.registerDefaultState(this.defaultBlockState().setValue(HORIZONTAL_FACING, Direction.NORTH));
    }

    public static final VoxelShape v = Stream.of(
            Block.box(0, 0, 12, 16, 1, 16),
            Block.box(0, 0, 0, 16, 1, 4),
            Block.box(0, 1, 3, 16, 4, 4),
            Block.box(0, 1, 12, 16, 4, 13),
            Block.box(0, 4, 3, 16, 6, 7),
            Block.box(0, 4, 9, 16, 6, 13),
            Block.box(0, 4, 7, 5, 6, 9),
            Block.box(6, 5, 7, 9, 7, 9),
            Block.box(10, 9, 5, 12, 10, 7),
            Block.box(10, 6, 5, 12, 9, 7),
            Block.box(14, 9, 5, 16, 14, 7),
            Block.box(12, 9, 5, 14, 9, 7),
            Block.box(9, 5, 7, 12, 6, 9),
            Block.box(15, 5, 7, 16, 6, 9),
            Block.box(8, 6, 4, 10, 8, 6),
            Block.box(8, 6, 10, 10, 8, 12),
            Block.box(2, 1, 1, 3, 1, 2),
            Block.box(13, 1, 1, 14, 2, 2),
            Block.box(2, 1, 1, 3, 2, 2),
            Block.box(2, 1, 14, 3, 2, 15),
            Block.box(13, 1, 14, 14, 2, 15),
            Block.box(13, 1, 14, 14, 1, 15),
            Block.box(2, 1, 14, 3, 1, 15)
    ).reduce((v1, v2) ->  join(v1, v2, BooleanOp.OR)).get();

    public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
}
