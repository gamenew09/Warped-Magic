package com.gamenew09.warpedmagic.lib;

import java.util.Arrays;

import net.minecraft.item.ItemStack;

public class MagicChargingRecipe {

	private ItemStack output;
	
	private int upgradeLevelReq;
	
	private ItemStack[] stuff;
	
	public MagicChargingRecipe(ItemStack out, int upgradeLevelReq, ItemStack[] stuff){
		this.output = out;
		this.stuff = stuff;
		this.upgradeLevelReq = upgradeLevelReq;
	}
	
	public int getUpgradeLevelRequired(){
		return upgradeLevelReq;
	}
	
	public ItemStack[] getStuffRequired(){
		return stuff;
	}
	
	public ItemStack getOutput(){
		return output;
	}
	
	@Override
	public String toString() {
		return "MagicChargingRecipe [output=" + output + ", upgradeLevelReq="
				+ upgradeLevelReq + ", stuff=" + Arrays.toString(stuff) + "]";
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
