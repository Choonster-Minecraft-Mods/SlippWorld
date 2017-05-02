package com.kain.slippworld;

import com.kain.slippworld.proxy.*;

import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.network.simpleimpl.*;

@Mod(name = Reference.NAME, modid = Reference.MOD_ID, version = Reference.VERSION)
public class SlippWorld {
	@SidedProxy(clientSide = "com.kain.slippworld.proxy.ClientProxy", serverSide = "com.kain.slippworld.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static SimpleNetworkWrapper channel;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit();
		proxy.preInitClient();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
		proxy.initClient();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
		proxy.postInitClient();
	}
}