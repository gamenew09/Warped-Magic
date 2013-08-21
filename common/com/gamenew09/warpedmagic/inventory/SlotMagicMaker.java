package com.gamenew09.warpedmagic.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotMagicMaker extends Slot {

	private boolean phantom;
	
	private ItemStack[] allowedItems;
	
	public SlotMagicMaker(IInventory par1iInventory, int par2, int par3, int par4, boolean phantom, ItemStack[] allowedItems) {
		super(par1iInventory, par2, par3, par4);
		this.phantom = phantom;
		this.allowedItems = allowedItems;
	}
	
	@Override
	public boolean isItemValid(ItemStack par1ItemStack) {
		boolean r = false;
		for(ItemStack is : allowedItems){
			if(is.isItemEqual(par1ItemStack)){
				r = true;
				break;
			}
		}
		return !phantom && r;
	}

}
