package com.kain.slippworld.item.tool;

import com.kain.slippworld.*;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;

public class ItemSwordMod extends ItemSword {
	public ItemSwordMod(ToolMaterial material) {
		super(material);

		String name = material.name() + "_sword";

		this.setRegistryName(Reference.MOD_ID, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
}