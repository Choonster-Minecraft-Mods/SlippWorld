package com.kain.slippworld.proxy;

import com.kain.slippworld.block.*;
import com.kain.slippworld.event.*;
import com.kain.slippworld.item.*;

import net.minecraftforge.common.*;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInitClient() {
		Items.initClient();
		Blocks.initClient();
	}

	@Override
	public void initClient() {
		MinecraftForge.EVENT_BUS.register(new RepeaterEvents());
	}

	@Override
	public void postInitClient() {
	}
}