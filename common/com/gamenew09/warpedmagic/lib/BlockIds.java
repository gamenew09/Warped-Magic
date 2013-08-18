package com.gamenew09.warpedmagic.lib;

import com.gamenew09.warpedmagic.WarpedMagicMod;

import net.minecraftforge.common.*;

public class BlockIds {
	
	public static int levitateWand = 2467;
	
	public static void resetUsingConfig(Configuration c){
		Property p1 = c.getItem("levitateWandID", 2467);
		p1.comment = "The Levitate Wand ID (Does not effect levels.)";
		levitateWand = p1.getInt(2467);
		WarpedMagicMod.log.fine("Resetted item/block ids using configuration.");
	}
}
