package com.gamenew09.warpedmagic.lib;

import com.gamenew09.warpedmagic.lib.world.WorldTime;

import net.minecraft.item.ItemStack;

public class MagicChargingRecipe {

	private ItemStack output;
	private WorldTime time;
	
	private ItemStack[] stuff;
	
	public MagicChargingRecipe(ItemStack out, WorldTime requiredTime, ItemStack[] stuff){
		this.output = out;
		this.time = requiredTime;
		this.stuff = stuff;
	}
	
	public ItemStack[] getStuffRequired(){
		return stuff;
	}
	
	public WorldTime getTimeCompletion(){
		return time;
	}
	
	public ItemStack getOutput(){
		return output;
	}
	
	public boolean equals(Object o){
		try{
			boolean isEqual = (((MagicChargingRecipe) o).getOutput() == this.getOutput()) && (((MagicChargingRecipe) o).getStuffRequired() == this.getStuffRequired());
			return isEqual;
		}catch(Exception e){
			return false;
		}
	}

}
