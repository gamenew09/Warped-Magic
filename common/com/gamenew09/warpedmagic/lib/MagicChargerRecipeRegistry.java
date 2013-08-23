package com.gamenew09.warpedmagic.lib;

import java.util.ArrayList;

import com.gamenew09.warpedmagic.WarpedMagicMod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MagicChargerRecipeRegistry {
	
	private static MagicChargerRecipeRegistry instance;
	
	private ArrayList<MagicChargingRecipe> recipes = new ArrayList<MagicChargingRecipe>();
	
	private MagicChargerRecipeRegistry(){ 
		addRecipesBuiltIn();
	}
	
	private void addRecipesBuiltIn(){
		addRecipe(new MagicChargingRecipe(new ItemStack(WarpedMagicMod.wandLevitate), 0, new ItemStack[]{
			new ItemStack(Item.diamond),
			new ItemStack(Item.stick),
			new ItemStack(Item.stick)
		}));
	}
	
	public static MagicChargerRecipeRegistry getInstance(){
		if(instance == null){
			instance = new MagicChargerRecipeRegistry();
			return instance;
		}
		return instance;
	}
	
	public void addRecipe(MagicChargingRecipe p){
		recipes.add(p);
	}
	
	public MagicChargingRecipe getRecipeMatch(ItemStack[] items, int upgradeLevelOnEntity){
		for(MagicChargingRecipe rec : recipes){
			boolean isMatch = rec.getStuffRequired() == items && rec.getUpgradeLevelRequired() >= upgradeLevelOnEntity;
			if(isMatch){
				return rec;
			}
		}
		return null;
	}
	
	public ArrayList<MagicChargingRecipe> getRecipeByItemStack(){
		return recipes;
	}
	
}
