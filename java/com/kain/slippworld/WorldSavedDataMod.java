package com.kain.slippworld;

import java.util.*;

import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.storage.*;

public class WorldSavedDataMod extends WorldSavedData {
	public static final String NAME = Reference.NAME + "_WorldData";

	public boolean isDragonSlain = false;

	public Map<ChunkPos, NBTTagCompound> chunkData;

	public WorldSavedDataMod(String name) {
		super(name);

		chunkData = new HashMap<ChunkPos, NBTTagCompound>();
	}

	public WorldSavedDataMod() {
		this(NAME);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		isDragonSlain = nbt.getBoolean(Reference.DRAGON_SLAIN_TAG);

		NBTTagCompound chunks = nbt.getCompoundTag(Reference.WORLD_DATA_CHUNKS);
		
		for(String pos : chunks.getKeySet()) {
			chunkData.put(fromString(pos), chunks.getCompoundTag(pos));
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		nbt.setBoolean(Reference.DRAGON_SLAIN_TAG, isDragonSlain);
		
		NBTTagCompound chunks = new NBTTagCompound();
		
		for(ChunkPos pos : chunkData.keySet()) {
			chunks.setTag(pos.toString(), chunkData.get(pos));
		}
		
		nbt.setTag(Reference.WORLD_DATA_CHUNKS, chunks);

		return nbt;
	}
	
	public NBTTagCompound getChunkData(ChunkPos pos) {
		NBTTagCompound nbt = chunkData.get(pos);
		
		if(nbt == null) {
			System.out.println("Chunk data not created, creating");
			
			nbt = new NBTTagCompound();
			chunkData.put(pos, nbt);
		}
		
		return nbt;
	}

	public static WorldSavedDataMod get(World w) {
		MapStorage s = w.getMapStorage();
		WorldSavedDataMod d = (WorldSavedDataMod) s.getOrLoadData(WorldSavedDataMod.class, NAME);

		if(d == null) {
			d = new WorldSavedDataMod();
			s.setData(NAME, d);
		}

		return d;
	}
	
	public ChunkPos fromString(String pos) {
		pos = pos.substring(1, pos.length() - 1);
		
		for(int i = 0; i < pos.length(); i++) {
			if(pos.charAt(i) == ',') {
				return new ChunkPos(Integer.parseInt(pos.substring(0, i)), Integer.parseInt(pos.substring(i + 2, pos.length())));
			}
		}
		
		return null;
	}
}