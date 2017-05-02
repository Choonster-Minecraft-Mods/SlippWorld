package com.kain.slippworld.network;

import io.netty.buffer.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.network.*;
import net.minecraftforge.fml.common.network.simpleimpl.*;

public class MessageTargetEntity implements IMessage {
	public int entityID;
	public ItemStack itemStack;

	public MessageTargetEntity() {
	}

	public MessageTargetEntity(EntityLivingBase entity, ItemStack itemStack) {
		this.entityID = entity.getEntityId();
		this.itemStack = itemStack;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		entityID = buf.readInt();
		itemStack = ByteBufUtils.readItemStack(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(entityID);
		ByteBufUtils.writeItemStack(buf, itemStack);
	}
}