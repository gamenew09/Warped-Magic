package com.gamenew09.warpedmagic.lib;

import com.gamenew09.warpedmagic.WarpedMagicMod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.*;

public class RecipeRegistry {
	
	public static void addRecipe(ItemStack out, Object[] stuff){
		GameRegistry.addRecipe(out, stuff);
	}
	
	public static void registerRecipes(){
		addRecipe(new ItemStack(WarpedMagicMod.wandLevitate), new Object[]{
			"X  "," S ","  S", Character.valueOf('X'), Item.diamond, Character.valueOf('S'), Item.stick
		});
	}
	
}
