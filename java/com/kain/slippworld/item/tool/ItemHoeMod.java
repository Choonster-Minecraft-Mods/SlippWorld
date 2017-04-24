package com.kain.slippworld.item.tool;

import com.kain.slippworld.*;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;

public class ItemHoeMod extends ItemHoe {
	public ItemHoeMod(ToolMaterial material) {
		super(material);
		
		String name = material.name() + "_hoe";
		
		this.setRegistryName(Reference.MOD_ID, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
}