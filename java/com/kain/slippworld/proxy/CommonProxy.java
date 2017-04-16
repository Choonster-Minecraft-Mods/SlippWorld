package com.kain.slippworld.proxy;

import com.kain.slippworld.block.*;
import com.kain.slippworld.item.*;

import net.minecraft.item.*;
import net.minecraftforge.fml.common.registry.*;

public abstract class CommonProxy {
	public void preInit() {
		Items.init();
		Blocks.init();
	}
	
	public void init() {
	}
	
	public void postInit() {
	}

	public abstract void preInitClient();
	public abstract void initClient();
	public abstract void postInitClient();
	
	private static void addFurnaceRecipes() {
		GameRegistry.addSmelting(Blocks.clinzicOre, new ItemStack(Items.clinzicIngot), 7);
	}
}