package com.gamenew09.warpedmagic.lib;

import java.util.ArrayList;

import com.gamenew09.warpedmagic.ModManager;
import com.gamenew09.warpedmagic.WarpedMagicMod;
import com.pahimar.ee3.item.ItemEE;
import com.pahimar.ee3.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.*;

public class RecipeRegistry {
	
	public static ArrayList<Item> inertStones = new ArrayList<Item>();
	
	public static void addRecipe(ItemStack out, Object[] stuff){
		GameRegistry.addRecipe(out, stuff);
	}
	
	public static void addShapelessRecipe(ItemStack out, Object[] stuff){
		GameRegistry.addShapelessRecipe(out, stuff);
	}
	
	private static void populateInertStones(){
		inertStones.add(com.pahimar.ee3.item.ModItems.miniumStone);
		inertStones.add(com.pahimar.ee3.item.ModItems.philStone);
	}
	
	public static void addEE3StoneRecipe(ItemStack out, Object[] stuff){
		for(Item item : inertStones){
			if(item == null){ continue; }
			Object[] o = stuff.clone();
			o[o.length - 1] = item;
			GameRegistry.addShapelessRecipe(out, o);
		}
	}
	
	public static void registerRecipes(){
		addRecipe(new ItemStack(WarpedMagicMod.wandLevitate), new Object[]{
			"X  "," S ","  S", Character.valueOf('X'), Item.diamond, Character.valueOf('S'), Item.stick
		});
	}
	
	public static void registerModRecipes(){
		ModManager mm = ModManager.getInstance();
		try{
			if(mm.isModInstalled(com.pahimar.ee3.lib.Reference.MOD_ID)){
				//WarpedMagicMod.instance.log.fine("Mod EE3 is installed.");
				populateInertStones();
				addEE3StoneRecipe(new ItemStack(WarpedMagicMod.wandLevitate), new Object[] { Item.shovelDiamond });
			}
		}catch(Exception e){
			
		}
	}
	
}
