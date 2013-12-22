package com.gamenew09.warpedmagic;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;

import com.gamenew09.warpedmagic.block.*;
import com.gamenew09.warpedmagic.handlers.*;
import com.gamenew09.warpedmagic.item.wand.*;
import com.gamenew09.warpedmagic.lib.*;
import com.gamenew09.warpedmagic.proxy.CommonProxy;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.MOD_VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class WarpedMagicMod {
	
	public static final Logger log = Logger.getLogger(Reference.MOD_ID);
	
	public static final Logger debugLog = Logger.getLogger(Reference.MOD_ID + " Debug");
	
	@SidedProxy(clientSide=Reference.MOD_CLIENT_PROXY, serverSide=Reference.MOD_SERVER_PROXY)
	public static CommonProxy proxy;
	
	public static void debug(String logMessage){
		debugLog.fine(logMessage);
	}
	
	public static void debug(Level l, String logMessage){
		debugLog.log(l, logMessage);
	}
	
	@Instance(Reference.MOD_ID)
	public static WarpedMagicMod instance;
	
	public static ItemBaseWand wandLevitate;
	
	private Configuration config;
	
	public Configuration getModConfig(){
		return config;
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		BlockIds.resetUsingConfig(config);
		wandLevitate = (ItemBaseWand) new ItemLevitateWand(BlockIds.levitateWand, 1).setCreativeTab(CreativeTabs.tabTools).setUnlocalizedName("wandLevitate");
		
		config.save();
		
		LanguageRegistry.addName(wandLevitate, "Levitate Wand");
		GameRegistry.registerFuelHandler(new FuelHandler());
	}
	
	//@EventHandler
	//public void serverStarted(FMLServerStartedEvent event){
	//	
	//}
	
	@EventHandler
	public void initMod(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		WarpedMagicMod.debug("Init Ended");
	}
	
}
