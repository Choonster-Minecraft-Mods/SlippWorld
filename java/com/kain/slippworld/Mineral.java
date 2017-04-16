package com.kain.slippworld;

import com.kain.slippworld.block.*;
import com.kain.slippworld.item.*;

import net.minecraft.block.*;
import net.minecraft.item.*;

public enum Mineral {
	CLINZIC(Items.clinzicIngot, null, Blocks.clinzicOre, Blocks.clinzicBlock),
	BALRIUM(Items.balriumIngot, null, Blocks.balriumOre, Blocks.balriumBlock),
	ESTRIAN(Items.estrianIngot, null, Blocks.estrianOre, Blocks.estrianBlock);

	public Item ingot, dust;
	public Block ore, block;

	Mineral(Item ingot, Item dust, Block ore, Block block) {
		this.ingot = ingot;
		this.dust = dust;
		this.ore = ore;
		this.block = block;
	}
}