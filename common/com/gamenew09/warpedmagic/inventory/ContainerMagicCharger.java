package com.gamenew09.warpedmagic.inventory;

import com.gamenew09.warpedmagic.lib.MagicChargerRecipeRegistry;
import com.gamenew09.warpedmagic.lib.MagicChargingRecipe;
import com.gamenew09.warpedmagic.tileentity.*;

import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
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
		addSlotToContainer(new SlotMagicMaker(tileEntity, 2, 117, 30, false, null));
		addSlotToContainer(new SlotMagicMaker(tileEntity, 3, 78, 30, false, new ItemStack[] {new ItemStack(Item.coal)}));
		addSlotToContainer(new SlotMagicMaker(tileEntity, 4, 78, 54, true, null));
		
		addPlayerInventory(playerInv);
	}
	
	private void printArray(Object[] objs){
		for(int i = 0; i < objs.length; i++){
			Object obj = objs[i];
			System.out.println(i+":"+obj);
		}
	}
	
	private void onSlotChanged(int par1, int par2, int par3, EntityPlayer par4EntityPlayer){
		ItemStack[] items = { tileEntity.getStackInSlot(0), tileEntity.getStackInSlot(1), tileEntity.getStackInSlot(2) };
		printArray(items);
		MagicChargingRecipe r = MagicChargerRecipeRegistry.getInstance().getRecipeMatch(items, tileEntity.getLevel());
		System.out.println("Test");
		if(r != null){
			System.out.println("AAA");
			int fuelReq = r.getUpgradeLevelRequired() + 1;
			if(fuelReq < tileEntity.getStackInSlot(3).stackSize){
				System.out.println("Yay! Recipe Found!");
				tileEntity.setInventorySlotContents(4, r.getOutput());
			}
		}
	}
	
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        /*if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 0)
            {
                if (!this.mergeItemStack(itemstack1, 9, 45, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }*/

        return itemstack;
    }
	
	private void resetRecipeThings(MagicChargingRecipe r){
		int fuelReq = 1 * r.getUpgradeLevelRequired();
		for(int i = 0; i < r.getStuffRequired().length; i++){
			if(!(i < 3)){
				break;
			}
			ItemStack required = r.getStuffRequired()[i];
			tileEntity.decrStackSize(i, required.stackSize);
		}
		tileEntity.decrStackSize(3, fuelReq);
	}
	
	@Override
	public ItemStack slotClick(int par1, int par2, int par3, EntityPlayer par4EntityPlayer) {
		ItemStack is = super.slotClick(par1, par2, par3, par4EntityPlayer);
		if(par1 < 4){
			onSlotChanged(par1, par2, par3, par4EntityPlayer);
		}else{
			MagicChargingRecipe r = MagicChargerRecipeRegistry.getInstance().getRecipeMatch(null, tileEntity.getLevel());
			if(r != null){
				resetRecipeThings(r);
			}
		}
		return is;
	}
	
	protected void addPlayerInventory(InventoryPlayer inventoryPlayer) {
		int i;
        int j;
        
		for (i = 0; i < 3; ++i)
        {
            for (j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + (i + 1) * 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
	}
	
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tileEntity.isUseableByPlayer(entityplayer);
	}

}
