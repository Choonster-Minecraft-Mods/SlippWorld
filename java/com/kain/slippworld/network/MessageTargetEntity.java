package com.kain.slippworld.network;

import io.netty.buffer.*;
import net.minecraft.entity.*;
import net.minecraftforge.fml.common.network.simpleimpl.*;

public class MessageTargetEntity implements IMessage {
	public int entityID;

	public MessageTargetEntity() {
	}

	public MessageTargetEntity(EntityLivingBase entity) {
		this.entityID = entity.getEntityId();
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		entityID = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(entityID);
	}
}
