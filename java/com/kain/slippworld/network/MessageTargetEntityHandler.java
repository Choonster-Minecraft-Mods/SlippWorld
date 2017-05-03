package com.kain.slippworld.network;

import com.kain.slippworld.item.tool.*;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.network.simpleimpl.*;

public class MessageTargetEntityHandler implements IMessageHandler<MessageTargetEntity, IMessage> {
	@Override
	public IMessage onMessage(MessageTargetEntity message, MessageContext ctx) {
		ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> {
			EntityPlayerMP player = ctx.getServerHandler().player;
			ItemStack activeItem = player.getActiveItemStack();

			if (activeItem.getItem() instanceof ItemRepeater) {
				Entity e = player.world.getEntityByID(message.entityID);

				if (e instanceof EntityLivingBase) {
					((ItemRepeater) activeItem.getItem()).attackEntity(activeItem, (EntityLivingBase) e, player);
				}
			}
		try {
			this.finalize();
		} catch(Throwable e) {
			e.printStackTrace();
		}
		});

		return null;
	}
}