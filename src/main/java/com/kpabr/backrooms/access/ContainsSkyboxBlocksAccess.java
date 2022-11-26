package com.kpabr.backrooms.access;

import java.util.HashMap;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public interface ContainsSkyboxBlocksAccess {

	HashMap<BlockPos, BlockState> getSkyboxBlocks();
}
