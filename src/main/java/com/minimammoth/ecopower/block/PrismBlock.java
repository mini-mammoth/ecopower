package com.minimammoth.ecopower.block;

import com.minimammoth.ecopower.EcoPower;
import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class PrismBlock extends AbstractGlassBlock {
    public PrismBlock() {
        super(Properties.create(Material.GLASS).sound(SoundType.WOOD).func_226896_b_());
        setRegistryName(EcoPower.MOD_ID, "prism");
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(BlockStateProperties.FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(BlockStateProperties.FACING)) {
            case DOWN:
                return VoxelShapes.combine(
                    makeCuboidShape(0, 14, 0, 16, 16, 16), // STAND
                    makeCuboidShape(4, 0, 4, 12, 14, 12), // SHAPE
                    IBooleanFunction.OR
            );
            default:
            case UP:
                return VoxelShapes.combine(
                        makeCuboidShape(0, 0, 0, 16, 2, 16), // STAND
                        makeCuboidShape(4, 2, 4, 12, 16, 12), // SHAPE
                        IBooleanFunction.OR
                );
            case NORTH:
                return VoxelShapes.combine(
                        makeCuboidShape(0, 0, 14, 16, 16, 16), // STAND
                        makeCuboidShape(4, 4, 0, 12, 12, 14), // SHAPE
                        IBooleanFunction.OR
                );
            case SOUTH:
                return VoxelShapes.combine(
                        makeCuboidShape(0, 0, 0, 16, 16, 2), // STAND
                        makeCuboidShape(4, 4, 2, 12, 12, 16), // SHAPE
                        IBooleanFunction.OR
                );
            case WEST:
                return VoxelShapes.combine(
                        makeCuboidShape(14, 0, 0, 16, 16, 16), // STAND
                        makeCuboidShape(0, 4, 4, 14, 12, 12), // SHAPE
                        IBooleanFunction.OR
                );
            case EAST:
                return VoxelShapes.combine(
                        makeCuboidShape(0, 0, 0, 2, 16, 16), // STAND
                        makeCuboidShape(2, 4, 4, 16, 12, 12), // SHAPE
                        IBooleanFunction.OR
                );
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(BlockStateProperties.FACING, context.getFace());
    }
}
