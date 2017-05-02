package com.kain.slippworld.data;

import java.util.*;

import com.kain.slippworld.*;

import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.storage.*;

public class RejuventationData extends WorldSavedData {
	public static final String NAME = Reference.NAME + "_WorldData";

	public boolean isDragonSlain = false;

	public Map<ChunkPos, NBTTagCompound> chunkData;

	public RejuventationData(String name) {
		super(name);

		chunkData = new HashMap<ChunkPos, NBTTagCompound>();
	}

	public RejuventationData() {
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
			//System.out.println("Chunk data not created, creating");

			nbt = new NBTTagCompound();
			chunkData.put(pos, nbt);
		}

		return nbt;
	}

	public static RejuventationData get(World w) {
		MapStorage s = w.getMapStorage();
		RejuventationData d = (RejuventationData) s.getOrLoadData(RejuventationData.class, NAME);

		if(d == null) {
			d = new RejuventationData();
			s.setData(NAME, d);
		}

		return d;
	}

	public static ChunkPos fromString(String pos) {
		pos = pos.substring(1, pos.length() - 1);

		for(int i = 0; i < pos.length(); i++) {
			if(pos.charAt(i) == ',') {
				return new ChunkPos(Integer.parseInt(pos.substring(0, i)), Integer.parseInt(pos.substring(i + 2, pos.length())));
			}
		}

		return null;
	}
}