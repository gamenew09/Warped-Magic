package com.gamenew09.warpedmagic.item.wand;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.world.World;

public abstract class ItemBaseWand extends Item {

	private int onUseDamageAmount;
	
	public ItemBaseWand(int par1, int onUseDamageAmount) {
		super(par1);
		this.onUseDamageAmount = onUseDamageAmount;
	}
	
	public abstract boolean doWandAction(ItemStack stack, EntityPlayer player, World world, int X, int Y, int Z, int side, float hitX, float hitY, float hitZ);
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int X, int Y, int Z, int side, float hitX, float hitY, float hitZ){
		boolean b = doWandAction(stack, player, world, X, Y, Z, side, hitX, hitY, hitZ);
		if(b){
			stack.damageItem(onUseDamageAmount, player);
		}
		return b;
	}
	
}
