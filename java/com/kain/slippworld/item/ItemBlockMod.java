package com.kain.slippworld.item;

import net.minecraft.block.*;
import net.minecraft.item.*;

public class ItemBlockMod extends ItemBlock {

	public ItemBlockMod(Block block) {
		super(block);

		this.setRegistryName(block.getRegistryName());
		this.setUnlocalizedName(block.getUnlocalizedName());
		this.setCreativeTab(block.getCreativeTabToDisplayOn());
	}
}