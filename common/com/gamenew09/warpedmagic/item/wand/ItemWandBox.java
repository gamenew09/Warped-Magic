package com.gamenew09.warpedmagic.item.wand;

import com.gamenew09.warpedmagic.lib.Box;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWandBox extends ItemBaseWand {

	public ItemWandBox(int par1) {
		super(par1, 0);
	}

	@Override
	public int getBurnTime(ItemStack s) {
		return 33000;
	}

	@Override
	public int getMaxWandLevel() {
		return 1;
	}

	@Override
	public boolean doWandAction(ItemStack stack, EntityPlayer player, World world, int X, int Y, int Z, int side, float hitX, float hitY, float hitZ) {
		
		return true;
	}

}
