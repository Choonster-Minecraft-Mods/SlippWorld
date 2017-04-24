package com.kain.slippworld.item;

import com.kain.slippworld.*;
import com.kain.slippworld.item.tool.*;

import net.minecraft.client.renderer.block.model.*;
import net.minecraft.creativetab.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.item.Item.*;
import net.minecraft.item.ItemArmor.*;
import net.minecraftforge.client.model.*;
import net.minecraftforge.fml.common.registry.*;
import net.minecraftforge.fml.relauncher.*;

public class Items {
	public static Item clinzicIngot, balriumIngot, estrianIngot;

	/**
	 * 0 = sword, 1 = pickaxe, 2 = shovel, 3 = axe, 4 = hoe
	 */
	public static Item[] clinzicTools, balriumTools, estrianTools;
	public static Item[] clinzicArmor, balriumArmor, estrianArmor;

	public static void init() {
		register(clinzicIngot = new ItemMod("clinzic_ingot").setCreativeTab(CreativeTabs.MATERIALS));
		register(balriumIngot = new ItemMod("balrium_ingot").setCreativeTab(CreativeTabs.MATERIALS));
		register(estrianIngot = new ItemMod("estrian_ingot").setCreativeTab(CreativeTabs.MATERIALS));

		register(clinzicTools = createTools(Mineral.CLINZIC.toolMaterial));
		register(balriumTools = createTools(Mineral.BALRIUM.toolMaterial));
		register(estrianTools = createTools(Mineral.ESTRIAN.toolMaterial));

		register(clinzicArmor = createArmor(Mineral.CLINZIC.armorMaterial));
		register(balriumArmor = createArmor(Mineral.BALRIUM.armorMaterial));
		register(estrianArmor = createArmor(Mineral.ESTRIAN.armorMaterial));
	}

	private static void register(Item i) {
		GameRegistry.register(i);
	}

	private static void register(Item[] items) {
		for(int i = 0; i < items.length; i++) {
			GameRegistry.register(items[i]);
		}
	}

	private static Item[] createTools(ToolMaterial material) {
		Item[] toolArray = new Item[5];

		
		toolArray[0] = new ItemSwordMod(material);
		toolArray[1] = new ItemPickaxeMod(material);
		toolArray[2] = new ItemShovelMod(material);
		toolArray[3] = new ItemAxeMod(material);
		toolArray[4] = new ItemHoeMod(material);

		return toolArray;
	}

	private static Item[] createArmor(ArmorMaterial material) {
		Item[] toolArray = new Item[4];

		toolArray[0] = new ItemArmorMod(material, EntityEquipmentSlot.HEAD);
		toolArray[1] = new ItemArmorMod(material, EntityEquipmentSlot.CHEST);
		toolArray[2] = new ItemArmorMod(material, EntityEquipmentSlot.LEGS);
		toolArray[3] = new ItemArmorMod(material, EntityEquipmentSlot.FEET);

		return toolArray;
	}

	@SideOnly(Side.CLIENT)
	public static void initClient() {
		registerRender(clinzicIngot);
		registerRender(balriumIngot);
		registerRender(estrianIngot);

		registerRender(clinzicTools);
		registerRender(balriumTools);
		registerRender(estrianTools);

		registerRender(clinzicArmor);
		registerRender(balriumArmor);
		registerRender(estrianArmor);
	}

	@SideOnly(Side.CLIENT)
	private static void registerRender(Item i) {
		ModelLoader.setCustomModelResourceLocation(i, 0, new ModelResourceLocation(i.getRegistryName(), "inventory"));
	}

	@SideOnly(Side.CLIENT)
	private static void registerRender(Item[] items) {
		for(int i = 0; i < items.length; i++) {
			ModelLoader.setCustomModelResourceLocation(items[i], 0, new ModelResourceLocation(items[i].getRegistryName(), "inventory"));
		}
	}
}