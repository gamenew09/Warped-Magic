package com.gamenew09.warpedmagic.lib;

import com.gamenew09.warpedmagic.WarpedMagicMod;

import net.minecraftforge.common.*;

public class BlockIds {
	
	public static int levitateWand = 2467;
	public static int magicChargerId = 228;
	
	public static void resetUsingConfig(Configuration c){
		Property p1 = c.getItem("levitateWandID", levitateWand);
		p1.comment = "The Levitate Wand ID (Does not effect levels.)";
		levitateWand = p1.getInt(2467);
		Property p2 = c.getItem("magicChargerId", magicChargerId);
		p2.comment = "The Magic Charger Id.";
		if(p2.getInt() != 31742){
			magicChargerId = p2.getInt(magicChargerId);
		}
		WarpedMagicMod.log.fine("Resetted item/block ids using configuration.");
	}
}
