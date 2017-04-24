package com.kain.slippworld;

import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.item.Item.*;
import net.minecraft.item.ItemArmor.*;
import net.minecraft.util.*;
import net.minecraftforge.common.util.*;
import net.minecraftforge.fml.common.registry.*;

public enum Mineral {
	CLINZIC(EnumHelper.addToolMaterial("clinzic", 4, 1500, 10.0F, 5.0F, 16), EnumHelper.addArmorMaterial("clinzic", "clinzic", 38, new int[] { 3, 6, 8, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0F)),
	BALRIUM(EnumHelper.addToolMaterial("balrium", 4, 3500, 8.0F, 4.0F, 8), EnumHelper.addArmorMaterial("balrium", "balrium", 38, new int[] { 3, 6, 8, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0F)),
	ESTRIAN(EnumHelper.addToolMaterial("estrian", 4, 1000, 6.0F, 2.0F, 24), EnumHelper.addArmorMaterial("estrian", "estrian", 38, new int[] { 3, 6, 8, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0F));

	public ToolMaterial toolMaterial;
	public ArmorMaterial armorMaterial;

	Mineral(ToolMaterial toolMaterial, ArmorMaterial armorMaterial) {
		this.toolMaterial = toolMaterial;
		this.armorMaterial = armorMaterial;
	}

	public Block getOre() {
		return GameData.getBlockRegistry().getObject(new ResourceLocation(Reference.MOD_ID, toolMaterial.name() + "_ore"));
	}

	public Block getBlock() {
		return GameData.getBlockRegistry().getObject(new ResourceLocation(Reference.MOD_ID, toolMaterial.name() + "_block"));
	}

	public Item getIngot() {
		return getMineralItem("ingot");
	}

	public Item getMineralItem(String item) {
		return GameData.getItemRegistry().getObject(new ResourceLocation(Reference.MOD_ID, toolMaterial.name() + "_" + item));
	}
}