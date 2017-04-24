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
			GameRegistry.addShapedRecipe(new ItemStack(m.block, 1), new Object[] { "III", "III", "III", 'I', m.ingot });
			GameRegistry.addShapelessRecipe(new ItemStack(m.ingot, 9), new Object[] { m.block });
		}
	}

	private static void addFurnaceRecipes() {
		for(Mineral m : Mineral.values()) {
			GameRegistry.addSmelting(m.ore, new ItemStack(m.ingot, 1), 7);
		}
	}
}