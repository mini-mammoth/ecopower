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

public class MirrorBlock extends AbstractGlassBlock {
    public MirrorBlock() {
        super(Properties.create(Material.GLASS).sound(SoundType.WOOD).variableOpacity());
        setRegistryName(EcoPower.MOD_ID, "mirror");
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(BlockStateProperties.HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return VoxelShapes.combine(
                makeCuboidShape(0, 0, 0, 16, 2, 16), // STAND
                VoxelShapes.combine(
                        makeCuboidShape(0, 2, 7, 2, 11, 9), // LEFT,
                        makeCuboidShape(14, 2, 7, 16, 11, 9), // RIGHT
                        IBooleanFunction.OR
                ),
                IBooleanFunction.OR
        );
    }
}
