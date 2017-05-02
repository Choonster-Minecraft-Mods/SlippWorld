package com.kain.slippworld.network;

import com.kain.slippworld.item.tool.*;

import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraftforge.fml.common.network.simpleimpl.*;

public class MessageTargetEntityHandler implements IMessageHandler<MessageTargetEntity, IMessage> {
	@Override
	public IMessage onMessage(MessageTargetEntity message, MessageContext ctx) {
		if(message.itemStack.getItem() instanceof ItemRepeater) {
			EntityPlayerMP player = ctx.getServerHandler().playerEntity;
			Entity e = player.world.getEntityByID(message.entityID);

			if(e instanceof EntityLivingBase) {
				((ItemRepeater) message.itemStack.getItem()).attackEntity(message.itemStack, (EntityLivingBase) e, player);
			}
		}
		
		try {
			this.finalize();
		} catch(Throwable e) {
			e.printStackTrace();
		}

		return null;
	}
}