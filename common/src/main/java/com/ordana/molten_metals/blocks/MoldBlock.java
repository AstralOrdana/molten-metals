package com.ordana.molten_metals.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class MoldBlock extends Block {
  protected static final VoxelShape FACING_X = Block.box(5, 0, 3, 11, 4, 13);
  protected static final VoxelShape FACING_Z = Block.box(3, 0, 5, 13, 4, 11);

  public MoldBlock(Properties properties) {
    super(properties);
    this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
  }


  public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
    Direction direction = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
    return direction.getAxis() == Direction.Axis.X ? FACING_X : FACING_Z;
  }

  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(BlockStateProperties.HORIZONTAL_FACING);
  }

  @Nullable
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    BlockState blockState = defaultBlockState();
    return blockState.setValue(BlockStateProperties.HORIZONTAL_FACING, context.getHorizontalDirection());
  }

  public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    return canAttach(level, pos, Direction.DOWN);
  }

  public static boolean canAttach(LevelReader reader, BlockPos pos, Direction direction) {
    BlockPos blockPos = pos.relative(direction);
    return reader.getBlockState(blockPos).isFaceSturdy(reader, blockPos, direction.getOpposite());
  }
}
