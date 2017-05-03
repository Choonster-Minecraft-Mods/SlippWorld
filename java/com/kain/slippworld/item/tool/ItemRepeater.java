package com.kain.slippworld.item.tool;

import javax.annotation.*;

import com.kain.slippworld.*;
import com.kain.slippworld.data.repeater.*;

import net.minecraft.creativetab.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.fml.relauncher.*;

public class ItemRepeater extends Item {
	public final ToolMaterial material;
	protected final float damage;
	protected final float distance;
	protected final int maxCoolDown;

	public ItemRepeater(ToolMaterial material, float distance, int maxCoolDown) {
		super();

		this.material = material;
		this.distance = distance;
		this.maxCoolDown = maxCoolDown;

		this.damage = material.getDamageVsEntity();
		this.maxStackSize = 1;
		this.setMaxDamage(material.getMaxUses() / 3);

		String name = material.name() + "_repeater";

		this.setRegistryName(Reference.MOD_ID, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.COMBAT);
	}

	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity e, int slot, boolean selected) {
		super.onUpdate(itemStack, world, e, slot, selected);

		if(e instanceof EntityPlayer) {
			EntityPlayer player = ((EntityPlayer) e);

			if(!itemStack.isEmpty() && player.getHeldItem(EnumHand.MAIN_HAND).equals(itemStack)) {
				player.resetActiveHand();
				player.setActiveHand(EnumHand.MAIN_HAND);
			}
		}

		if(!world.isRemote) {
			IRepeaterData data = RepeaterCapability.getCapability(itemStack);

			if(data != null) {
				int coolDown = data.getCoolDown();

				if(coolDown > 0) {
					System.out.println("COOL DOWN");
					data.setCoolDown(--coolDown);
				}
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemeStack) {
		return Integer.MAX_VALUE;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack itemStack) {
		return EnumAction.BOW;
	}

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return slotChanged;
	}

	@Override
	@Nullable
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {
		return RepeaterCapability.createProvider();
	}

	public void attackEntity(ItemStack itemStack, EntityLivingBase entity, EntityPlayer player) {
		if(!player.world.isRemote) {
			IRepeaterData data = RepeaterCapability.getCapability(itemStack);

			if (data != null) {
				if (data.getCoolDown() == 0) {
					entity.hurtResistantTime = 0;
					entity.attackEntityFrom(DamageSource.GENERIC, getDamage());

					data.setCoolDown(100);

					player.world.playSound(null, player.posX, player.posY, player.posZ, Sounds.repeater, SoundCategory.PLAYERS, 5F, -1F);

					System.out.println("BANG");
				} else {
					System.out.println("ON COOLDOWN");
				}
			}
		}
	}

	public float getDistance() {
		return distance;
	}

	public float getDamage() {
		return damage;
	}

	public int getMaxCoolDown() {
		return maxCoolDown;
	}
}