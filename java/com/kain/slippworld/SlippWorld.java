package com.kain.slippworld;

import com.kain.slippworld.proxy.*;

import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.*;

@Mod(modid = SlippWorld.MOD_ID, version = SlippWorld.VERSION)
public class SlippWorld {
	public static final String MOD_ID = "slippworld";
	public static final String VERSION = "1.11.2-r1";

	@SidedProxy(clientSide = "com.kain.slippworld.proxy.ClientProxy", serverSide = "com.kain.slippworld.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.init();
		proxy.initClient();
	}
}