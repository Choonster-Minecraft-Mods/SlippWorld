package com.kain.slippworld.item.tool;

import com.kain.slippworld.*;

import net.minecraft.creativetab.*;
import net.minecraft.entity.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;

public class ItemArmorMod extends ItemArmor {
	public ItemArmorMod(ArmorMaterial material, EntityEquipmentSlot eq) {
		super(material, 0, eq);

		String slotName = "_";

		switch(eq) {
		case HEAD:
			slotName += "helmet";
			break;
		case CHEST:
			slotName += "chestplate";
			break;
		case LEGS:
			slotName += "leggings";
			break;
		case FEET:
			slotName += "boots";
			break;
		}

		String name = material.name() + slotName;

		this.setRegistryName(Reference.MOD_ID, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.COMBAT);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		return Reference.MOD_ID + ":textures/armor/" + this.getArmorMaterial().name() + "_" + (slot == EntityEquipmentSlot.LEGS ? "2" : "1") + ".png";
	}
}