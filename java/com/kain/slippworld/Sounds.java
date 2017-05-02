package com.kain.slippworld;

import net.minecraft.util.*;
import net.minecraftforge.fml.common.registry.*;

public class Sounds {
	public static SoundEvent repeater;

	public static void init() {
		repeater = createSound("repeater");
	}

	private static SoundEvent createSound(String sound) {
		ResourceLocation res = new ResourceLocation(Reference.MOD_ID, sound);
		SoundEvent se = new SoundEvent(res);

		GameRegistry.register(se, res);

		return se;
	}
}