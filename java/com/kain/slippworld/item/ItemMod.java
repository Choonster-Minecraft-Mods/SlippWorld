package com.kain.slippworld.item;

import com.kain.slippworld.*;

import net.minecraft.item.*;

public class ItemMod extends Item {
	public ItemMod(String name) {
		super();

		this.setRegistryName(Reference.MOD_ID, name);
		this.setUnlocalizedName(name);
	}
}