package com.gamenew09.warpedmagic.handlers;

import com.gamenew09.warpedmagic.item.wand.ItemBaseWand;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.getItem() instanceof ItemBaseWand){
			System.out.println("a");
			ItemBaseWand wand = (ItemBaseWand) fuel.getItem();
			if(wand.getBurnTime(fuel) > 0){
				return wand.getBurnTime(fuel);
			}
		}
		return 0;
	}

}
