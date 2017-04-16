package com.kain.slippworld.block;

import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BlockCompressed extends BlockMod {
	public BlockCompressed(String name) {
		super(Material.IRON, name);

		this.setLightLevel(1.0F);
		this.setHardness(3.0F);
		this.setResistance(10.0F);
		this.setSoundType(SoundType.METAL);
	}
}