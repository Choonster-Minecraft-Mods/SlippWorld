package com.kain.slippworld.proxy;

import com.kain.slippworld.block.*;
import com.kain.slippworld.item.*;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInitClient() {
		Items.initClient();
		Blocks.initClient();
	}

	@Override
	public void initClient() {
	}
	@Override
	public void postInitClient() {
	}
}