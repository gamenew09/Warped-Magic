package com.gamenew09.warpedmagic;

import java.util.logging.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;

import com.gamenew09.warpedmagic.handlers.*;
import com.gamenew09.warpedmagic.item.wand.*;
import com.gamenew09.warpedmagic.lib.*;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.MOD_VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class WarpedMagicMod {
	
	public static final Logger log = Logger.getLogger(WarpedMagicMod.class.getSimpleName());
	
	public static ItemBaseWand wandLevitate;
	
	public static boolean isBuildcraftInstalled(){
		try {
			Class.forName("buildcraft.api.core.BuildCraftAPI");
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		BlockIds.resetUsingConfig(config);
		
		wandLevitate = (ItemBaseWand) new ItemLevitateWand(BlockIds.levitateWand, 1).setCreativeTab(CreativeTabs.tabTools);
		
		config.save();
		
		LanguageRegistry.addName(wandLevitate, "Levitate Wand");
		RecipeRegistry.registerRecipes();
		GameRegistry.registerFuelHandler(new FuelHandler());
	}
	
	//public void serverStarted(FMLServerStartedEvent event){
	//	
	//}
	
	@EventHandler
	public void initMod(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
}
