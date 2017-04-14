package com.kain.slippworld.item;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.registry.*;

public class Items {
	public static Item clinzicIngot;
	
	public static void init() {
		register(clinzicIngot = new ItemMod("clinzic_ingot").setCreativeTab(CreativeTabs.MATERIALS));
	}
	
	private static void register(Item i) {
		GameRegistry.register(i);
	}
}