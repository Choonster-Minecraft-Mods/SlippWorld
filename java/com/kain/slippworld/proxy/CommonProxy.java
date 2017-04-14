package com.kain.slippworld.proxy;

import com.kain.slippworld.item.*;

public abstract class CommonProxy {
	public void init() {
		Items.init();
	}

	public abstract void initClient();
}