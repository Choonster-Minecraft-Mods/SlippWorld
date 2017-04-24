package com.kain.slippworld.proxy;

import com.kain.slippworld.*;
import com.kain.slippworld.block.*;
import com.kain.slippworld.event.*;
import com.kain.slippworld.item.*;

import net.minecraft.item.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.registry.*;

public abstract class CommonProxy {
	public void preInit() {
		Items.init();
		Blocks.init();
	}

	public void init() {
		addCraftingRecipes();
		addFurnaceRecipes();

		MinecraftForge.EVENT_BUS.register(new WorldRejuvenationEvent());
	}

	public void postInit() {
	}

	public abstract void preInitClient();

	public abstract void initClient();

	public abstract void postInitClient();

	private static void addCraftingRecipes() {
		for(Mineral m : Mineral.values()) {
			GameRegistry.addShapedRecipe(new ItemStack(m.getBlock(), 1), new Object[] { "III", "III", "III", 'I', m.getIngot() });
			GameRegistry.addShapelessRecipe(new ItemStack(m.getIngot(), 9), new Object[] { m.getBlock() });

			Item stick = net.minecraft.init.Items.STICK;

			GameRegistry.addShapedRecipe(new ItemStack(m.getMineralItem("sword"), 1), new Object[] { " I ", " I ", " S ", 'I', m.getIngot(), 'S', stick });
			GameRegistry.addShapedRecipe(new ItemStack(m.getMineralItem("pickaxe"), 1), new Object[] { "III", " S ", " S ", 'I', m.getIngot(), 'S', stick });
			GameRegistry.addShapedRecipe(new ItemStack(m.getMineralItem("shovel"), 1), new Object[] { " I ", " S ", " S ", 'I', m.getIngot(), 'S', stick });
			GameRegistry.addShapedRecipe(new ItemStack(m.getMineralItem("axe"), 1), new Object[] { "II ", "IS ", " S ", 'I', m.getIngot(), 'S', stick });
			GameRegistry.addShapedRecipe(new ItemStack(m.getMineralItem("axe"), 1), new Object[] { " II", " SI", " S ", 'I', m.getIngot(), 'S', stick });
			GameRegistry.addShapedRecipe(new ItemStack(m.getMineralItem("hoe"), 1), new Object[] { "II ", " S ", " S ", 'I', m.getIngot(), 'S', stick });
			GameRegistry.addShapedRecipe(new ItemStack(m.getMineralItem("hoe"), 1), new Object[] { " II", " S ", " S ", 'I', m.getIngot(), 'S', stick });

			GameRegistry.addShapedRecipe(new ItemStack(m.getMineralItem("helmet"), 1), new Object[] { "III", "I I", 'I', m.getIngot() });
			GameRegistry.addShapedRecipe(new ItemStack(m.getMineralItem("chestplate"), 1), new Object[] { "I I", "III", "III", 'I', m.getIngot() });
			GameRegistry.addShapedRecipe(new ItemStack(m.getMineralItem("leggings"), 1), new Object[] { "III", "I I", "I I", 'I', m.getIngot() });
			GameRegistry.addShapedRecipe(new ItemStack(m.getMineralItem("boots"), 1), new Object[] { "I I", "I I", 'I', m.getIngot() });
		}
	}

	private static void addFurnaceRecipes() {
		for(Mineral m : Mineral.values()) {
			GameRegistry.addSmelting(m.getOre(), new ItemStack(m.getIngot(), 1), 7);
		}
	}
}