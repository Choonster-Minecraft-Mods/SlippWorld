package com.kain.slippworld.data.repeater;

public class RepeaterData implements IRepeaterData {
	private int coolDown;
	
	@Override
	public int getCoolDown() {
		return coolDown;
	}

	@Override
	public void setCoolDown(int coolDown) {
		this.coolDown = coolDown;
	}

}