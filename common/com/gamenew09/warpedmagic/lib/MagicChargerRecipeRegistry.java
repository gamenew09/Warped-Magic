package com.gamenew09.warpedmagic.lib;

import java.util.ArrayList;

public class MagicChargerRecipeRegistry {
	
	private static MagicChargerRecipeRegistry instance;
	
	private ArrayList<MagicChargingRecipe> recipes = new ArrayList<MagicChargingRecipe>();
	
	private MagicChargerRecipeRegistry(){ }
	
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
	
	public ArrayList<MagicChargingRecipe> getRecipeByItemStack(){
		return recipes;
	}
	
}
