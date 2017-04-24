package com.kain.slippworld.block;

import com.kain.slippworld.*;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraftforge.fml.relauncher.*;

public class BlockMod extends Block {
	public BlockMod(Material m, String name) {
		super(m);

		this.setRegistryName(Reference.MOD_ID, name);
		this.setUnlocalizedName(name);
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.SOLID;
	}

	@Override
	public boolean isOpaqueCube(IBlockState ibs) {
		return true;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState ibs) {
		return EnumBlockRenderType.MODEL;
	}
}