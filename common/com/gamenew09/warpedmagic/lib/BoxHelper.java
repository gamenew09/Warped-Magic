package com.gamenew09.warpedmagic.lib;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BoxHelper {
	
	public static void spawnBox(World w, Box box, Block b, int metadata){
		int[][] boxArray = box.getPositionArray();
		for(int y = 0; y < 3; y++){
			int[] x = boxArray[y];
			w.setBlock(x[0], x[1], x[2], b.blockID, metadata, 3);
		}
	}
	
	public static void createBoxBasedOnPosition(Position3 pos, Position3 add){
		Box b = null;
		
	}
	
}
