package com.kain.slippworld.event;

import com.kain.slippworld.*;
import com.kain.slippworld.client.*;
import com.kain.slippworld.item.tool.*;
import com.kain.slippworld.network.*;

import net.minecraft.client.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.RayTraceResult.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.event.entity.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class RepeaterEvents {
	@SubscribeEvent
	public void renderPlayer(RenderPlayerEvent.Pre e) {
		ItemStack itemStack = e.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND);
		ModelBiped model = e.getRenderer().getMainModel();

		if(!itemStack.isEmpty() && itemStack.getItem() instanceof ItemRepeater) {
			model.rightArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
			model.leftArmPose = ModelBiped.ArmPose.EMPTY;
		}
	}

	@SubscribeEvent
	public void rightClick(MouseEvent e) {
		if(e.getButton() == 1 && e.isButtonstate()) { //1 is right button, isButtonState returns true if click, false if release
			EntityPlayer player = Minecraft.getMinecraft().player;
			ItemStack itemStack = player.getActiveItemStack();

			if(!itemStack.isEmpty() && player.getHeldItem(EnumHand.MAIN_HAND).equals(itemStack) && itemStack.getItem() instanceof ItemRepeater) {
				RayTraceResult ray = ClientUtil.getMouseOverExtended(((ItemRepeater) itemStack.getItem()).getDistance());

				if(ray.entityHit != null && ray.typeOfHit == Type.ENTITY && ray.entityHit instanceof EntityLivingBase) {
					EntityLivingBase entity = (EntityLivingBase) ray.entityHit;

					SlippWorld.channel.sendToServer(new MessageTargetEntity(entity));
				}
			}
		}
	}
}