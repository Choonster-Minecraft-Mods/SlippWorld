package com.kain.slippworld.data.repeater;

import com.kain.slippworld.*;
import com.kain.slippworld.data.*;

import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraftforge.common.capabilities.*;

public class RepeaterCapability {
	public static final ResourceLocation NAME = new ResourceLocation(Reference.MOD_ID, "_Repeater");

	@CapabilityInject(IRepeaterData.class)
	public static final Capability<IRepeaterData> REPEATER_DATA_CAPABILITY = null;

	public static final EnumFacing DEFAULT_FACING = null;

	public static void register() {
		CapabilityManager.INSTANCE.register(IRepeaterData.class, new Capability.IStorage<IRepeaterData>() {
			@Override
			public NBTBase writeNBT(Capability<IRepeaterData> capability, IRepeaterData instance, EnumFacing side) {
				return new NBTTagInt(instance.getCoolDown());
			}

			@Override
			public void readNBT(Capability<IRepeaterData> capability, IRepeaterData instance, EnumFacing side, NBTBase nbt) {
				instance.setCoolDown(((NBTTagInt) nbt).getInt());
			}
		}, () -> new RepeaterData());
	}

	public static IRepeaterData getCapability(ItemStack itemStack) {
		return itemStack != null && itemStack.hasCapability(REPEATER_DATA_CAPABILITY, DEFAULT_FACING) ? itemStack.getCapability(REPEATER_DATA_CAPABILITY, DEFAULT_FACING) : null;
	}

	public static ICapabilityProvider createProvider() {
		return new GenericCapabilityProvider<>(REPEATER_DATA_CAPABILITY, DEFAULT_FACING);
	}

	public static ICapabilityProvider createProvider(IRepeaterData repeaterData) {
		return new GenericCapabilityProvider(REPEATER_DATA_CAPABILITY, DEFAULT_FACING, repeaterData);
	}
}