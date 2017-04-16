package com.kain.slippworld.block;

import java.util.*;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.creativetab.*;
import net.minecraft.init.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class BlockOreMod extends BlockMod {
	public BlockOreMod(String name) {
		super(Material.ROCK, name);
		
		this.setHarvestLevel("pickaxe", 3);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		this.setLightLevel(0.625F);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

	public int quantityDropped(Random random) {
		return 1;
	}

	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(this);
	}

	public int damageDropped(IBlockState state) {
		return 0;
	}
}