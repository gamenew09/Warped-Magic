package com.gamenew09.warpedmagic;

import java.util.logging.Logger;

import buildcraft.api.core.BuildCraftAPI;

import com.gamenew09.warpedmagic.lib.Reference;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.*;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.MOD_VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class WarpedMagicMod {
	
	public static final Logger logger = Logger.getLogger(WarpedMagicMod.class.getSimpleName());
	
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
		
	}
	
	@EventHandler
	public void initMod(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
}
