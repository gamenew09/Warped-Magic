package com.gamenew09.warpedmagic;

import java.util.logging.*;

import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

import com.gamenew09.warpedmagic.block.*;
import com.gamenew09.warpedmagic.creativetabs.*;
import com.gamenew09.warpedmagic.generator.OreGenerator;
import com.gamenew09.warpedmagic.handlers.*;
import com.gamenew09.warpedmagic.item.ItemRedCrystal;
import com.gamenew09.warpedmagic.item.wand.*;
import com.gamenew09.warpedmagic.lib.*;
import com.gamenew09.warpedmagic.proxy.CommonProxy;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.registry.*;

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
	
	public static CreativeTabs tabWand = new CreativeTabWand();
	public static CreativeTabs tabBlocksnItems = new CreativeTabBlockItem();
	
	@Instance(Reference.MOD_ID)
	public static WarpedMagicMod instance;
	
	public static Item redCrystal;
	
	public static ItemBaseWand wandLevitate;
	
	public static BlockOre redCrystalOre;
	
	private Configuration config;
	
	public Configuration getModConfig(){
		return config;
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		BlockIds.resetUsingConfig(config);
		wandLevitate = (ItemBaseWand) new ItemLevitateWand(BlockIds.levitateWand, 1).setUnlocalizedName("wandLevitate");
		redCrystalOre = new BlockRedCrystalOre(254);
		redCrystal = new ItemRedCrystal(2435).setUnlocalizedName("redCrystal").setCreativeTab(tabBlocksnItems);
		
		GameRegistry.registerBlock(redCrystalOre, "redCrystalOre");
		
		config.save();
		
		//Generation
		GameRegistry.registerWorldGenerator(new OreGenerator());
		//End Generation
		
		GameRegistry.registerFuelHandler(new FuelHandler());
		
		//Recipes
		GameRegistry.addRecipe(new ItemStack(wandLevitate), new Object[] {
			"XF ", " S ", "  S", Character.valueOf('X'), redCrystal, Character.valueOf('F'), Item.feather, Character.valueOf('S'), Item.stick
		});
		ItemBaseWand.addLevelRecipes(wandLevitate, new ItemStack(redCrystal));
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
