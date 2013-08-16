package com.gamenew09.warpedmagic.item.wand;

import java.util.List;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.world.World;

public abstract class ItemBaseWand extends Item {

	protected int onUseDamageAmount;
	
	public ItemBaseWand(int par1, int onUseDamageAmount) {
		super(par1);
		this.setMaxStackSize(1);
		this.onUseDamageAmount = onUseDamageAmount;
	}
	
	public abstract int getBurnTime(ItemStack s);
	
	private int getLevelByMetaData(ItemStack stack){
		return stack.getItemDamage() + 1;
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Level "+getLevelByMetaData(par1ItemStack));
	}
	
	public abstract boolean doWandAction(ItemStack stack, EntityPlayer player, World world, int X, int Y, int Z, int side, float hitX, float hitY, float hitZ);
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int X, int Y, int Z, int side, float hitX, float hitY, float hitZ){
		boolean b = doWandAction(stack, player, world, X, Y, Z, side, hitX, hitY, hitZ);
		return b;
	}
	
}
