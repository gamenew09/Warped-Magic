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
		addRecipe(new MagicChargingRecipe(new ItemStack((Item)WarpedMagicMod.wandLevitate, 1), 0, new ItemStack[]{
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
	
	private boolean onlyContainsAll(Object[] comp, Object[] comp2){
		boolean[] contains = new boolean[comp2.length];
		if(comp.length > comp2.length || comp.length < comp2.length){
			return false;
		}
		for(Object obj : comp){
			for(int i = 0; i < comp2.length; i++){
				if(comp2[i] == obj && contains[i] == false){
					contains[i] = true;
				}
			}
		}
		int a = 0;
		for(int b = 0; b < contains.length; b++){
			if(contains[b] == true){
				a++;
			}
		}
		return a == contains.length - 1;
	}
	
	public boolean itemstackCheck(ItemStack[] is, ItemStack[] is1){
		try{
			boolean[] contains = new boolean[is1.length];
			if(onlyContainsAll(is, is1)){
				return true;
			}
			for(ItemStack itemStack : is){
				for(int i = 0; i < is1.length; i++){
					System.out.println(itemStack.toString());
					if(itemStack.getItem() == is1[i].getItem() && contains[i] == false){
						contains[i] = true;
					}
				}
			}
			int a = 0;
			for(int b = 0; b < contains.length; b++){
				if(contains[b] == true){
					a++;
				}
			}
			return a == contains.length - 1;
		}
		catch(Exception e){
			System.out.println("Only caught me once *cough*twice*cough* Mr." + e.getClass().getSimpleName() + " D:");
			return false;
		}
	}
	
	public MagicChargingRecipe getRecipeMatch(ItemStack[] items, int upgradeLevelOnEntity){
		for(MagicChargingRecipe rec : recipes){
			System.out.println(itemstackCheck(rec.getStuffRequired(), items) +" and "+ (rec.getUpgradeLevelRequired() <= upgradeLevelOnEntity));
			boolean isMatch = itemstackCheck(rec.getStuffRequired(), items) && rec.getUpgradeLevelRequired() <= upgradeLevelOnEntity;
			System.out.println(rec.toString());
			if(isMatch){
				System.out.println("Sucess!");
				return rec;
			}
		}
		return null;
	}
	
	public ArrayList<MagicChargingRecipe> getRecipeByItemStack(){
		return recipes;
	}
	
}
