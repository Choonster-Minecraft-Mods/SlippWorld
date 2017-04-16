package com.kain.slippworld.block;

import com.kain.slippworld.item.*;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.item.*;
import net.minecraftforge.client.model.*;
import net.minecraftforge.fml.common.registry.*;
import net.minecraftforge.fml.relauncher.*;

public class Blocks {
	public static Block clinzicOre;

	public static void init() {
		register(clinzicOre = new BlockOreMod("clinzic_ore", Items.clinzicIngot));
	}

	private static void register(Block b) {
		GameRegistry.register(b);
		GameRegistry.register(new ItemBlockMod(b));
	}

	@SideOnly(Side.CLIENT)
	public static void initClient() {
		registerRender(clinzicOre);
	}

	@SideOnly(Side.CLIENT)
	private static void registerRender(Block b) {
		Item item = Item.getItemFromBlock(b);

		ModelResourceLocation model = new ModelResourceLocation(b.getRegistryName(), "inventory");
		ModelLoader.setCustomModelResourceLocation(item, 0, model);
	}
}