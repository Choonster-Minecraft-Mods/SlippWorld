package com.kain.slippworld.item.tool;

import com.kain.slippworld.*;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.item.Item.*;

public class ItemShovelMod extends ItemSpade {
	public ItemShovelMod(ToolMaterial material) {
		super(material);
		
		String name = material.name() + "_shovel";
		
		this.setRegistryName(Reference.MOD_ID, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
}