package com.gamenew09.warpedmagic.inventory;

import com.gamenew09.warpedmagic.tileentity.*;

import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ContainerMagicCharger extends Container {
	
	private TileEntityMagicCharger tileEntity;
	
	public ContainerMagicCharger(InventoryPlayer playerInv, TileEntityMagicCharger c){
		tileEntity = c;
		
		//39 30 first craft slot
		//78 8 second craft slot
		//117 30 third craft slot
		//78 30 fuel slot
		//78 54 crafted final slot
		
		addSlotToContainer(new SlotMagicMaker(tileEntity, 0, 39, 30, false, null));
		addSlotToContainer(new SlotMagicMaker(tileEntity, 1, 78, 8, false, null));
		addSlotToContainer(new SlotMagicMaker(tileEntity, 2, 177, 30, false, null));
		addSlotToContainer(new SlotMagicMaker(tileEntity, 3, 78, 30, false, new ItemStack[] {new ItemStack(Item.coal)}));
		
		addPlayerInventory(playerInv, 6);
	}
	
	protected void addPlayerInventory(InventoryPlayer inventoryPlayer, int startFromId) {
		//Actual Inventory
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventoryPlayer, j + i * startFromId, 8 + j * 18, 84 + i * 18));
			}
		}
		//Hotbar
		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i + startFromId, 8 + i * 18, 142));
		}
	}
	
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tileEntity.isUseableByPlayer(entityplayer);
	}

}
