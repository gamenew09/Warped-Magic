package com.gamenew09.warpedmagic.inventory;

import com.gamenew09.warpedmagic.tileentity.TileEntityMagicCharger;

import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;

public class ContainerMagicCharger extends Container {
	
	private TileEntityMagicCharger tileEntity;
	
	public ContainerMagicCharger(InventoryPlayer playerInv, TileEntityMagicCharger c){
		tileEntity = c;
		addPlayerInventory(playerInv);
	}
	
	protected void addPlayerInventory(InventoryPlayer inventoryPlayer) {
		//Actual Inventory
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		//Hotbar
		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}
	
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tileEntity.isUseableByPlayer(entityplayer);
	}

}
