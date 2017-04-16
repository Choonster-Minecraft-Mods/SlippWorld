package com.kain.slippworld.item;

import com.kain.slippworld.*;

import net.minecraft.client.renderer.block.model.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraftforge.client.model.*;
import net.minecraftforge.fml.common.registry.*;
import net.minecraftforge.fml.relauncher.*;

public class Items {
	public static Item clinzicIngot;

	public static void init() {
		register(clinzicIngot = new ItemMod("clinzic_ingot").setCreativeTab(CreativeTabs.MATERIALS));
	}

	private static void register(Item i) {
		GameRegistry.register(i);
	}

	@SideOnly(Side.CLIENT)
	public static void initClient() {
		registerRender(clinzicIngot);
	}

	@SideOnly(Side.CLIENT)
	private static void registerRender(Item i) {
		ModelLoader.setCustomModelResourceLocation(i, 0, new ModelResourceLocation(i.getRegistryName(), "inventory"));
	}
}