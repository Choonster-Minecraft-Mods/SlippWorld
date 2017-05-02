package com.kain.slippworld.event;

import java.util.*;

import com.kain.slippworld.*;
import com.kain.slippworld.block.*;
import com.kain.slippworld.data.*;

import net.minecraft.block.*;
import net.minecraft.block.state.pattern.*;
import net.minecraft.entity.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.world.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class WorldRejuvenationEvent {
	public static final boolean IS_DRAGON_DEAD = true;

	@SubscribeEvent
	public void chunkSave(ChunkDataEvent.Save e) {
		World w = e.getWorld();

		if(!w.isRemote) {
			RejuventationData data = RejuventationData.get(w);
			NBTTagCompound nbt = data.getChunkData(e.getChunk().getPos());

			if(data.isDragonSlain) {
				if(!nbt.hasKey(Reference.CHUNK_REJUVENATED_TAG)) {
					nbt.setBoolean(Reference.CHUNK_REJUVENATED_TAG, true);

					//System.out.println("Generating new ores");

					genOres(e.getChunk(), Blocks.clinzicOre, Reference.clinzicVeinSize, Reference.clinzicPerChunk, Reference.clinzicMinY, Reference.clinzicMaxY);
					genOres(e.getChunk(), Blocks.balriumOre, Reference.balriumVeinSize, Reference.balriumPerChunk, Reference.balriumMinY, Reference.balriumMaxY);
					genOres(e.getChunk(), Blocks.estrianOre, Reference.estrianVeinSize, Reference.estrianPerChunk, Reference.estrianMinY, Reference.estrianMaxY);

					e.getChunk().setModified(true);
					data.markDirty();
				} else {
					//System.out.println("Chunk already has ores");
				}
			} else {
				//System.out.println("Dragon hasn't been slain yet");
			}
		}
	}

	@SubscribeEvent
	public void entityDeath(LivingDeathEvent ev) {
		EntityLivingBase e = ev.getEntityLiving();

		if(!e.world.isRemote) {
			if(e instanceof EntityDragon) {
				RejuventationData data = RejuventationData.get(e.world);

				data.isDragonSlain = true;
				data.markDirty();

				List<EntityPlayerMP> players = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers();

				for(EntityPlayerMP p : players) {
					p.sendMessage(new TextComponentString("The earth trembles below you..."));
				}

				//System.out.println("The dragon's been slain!");
			}
		}
	}

	private static void genOres(Chunk chunk, Block ore, int veinSize, int perChunk, int minY, int maxY) {
		WorldGenMinable gen = new WorldGenMinable(ore.getDefaultState(), veinSize, BlockMatcher.forBlock(net.minecraft.init.Blocks.STONE));
		Random r = new Random();

		for(int i = 0; i < perChunk; i++) {
			gen.generate(chunk.getWorld(), r, new BlockPos(chunk.xPosition * 16 + r.nextInt(16), minY + r.nextInt(maxY - minY), chunk.zPosition * 16 + r.nextInt(16)));
		}
	}
}