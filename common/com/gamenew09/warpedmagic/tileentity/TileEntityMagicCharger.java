package com.gamenew09.warpedmagic.tileentity;

import java.util.ArrayList;

import com.gamenew09.warpedmagic.lib.EventAction;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMagicCharger extends TileEntity implements IInventory {
	
	private ArrayList<EventAction> eventsTick = new ArrayList<EventAction>();
	
	private ItemStack[] inventory;
	
	private int upgradeLevel = 0;
	
	public TileEntityMagicCharger(){
		inventory = new ItemStack[5];
		//0-2 crafting stuff, 3 fuel, 4 final
	}
	
	public void addTickEvent(EventAction e){
		eventsTick.add(e);
	}
	
	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return inventory[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		ItemStack stack = inventory[i];
		stack.stackSize -= j;
		inventory[i] = stack;
		return stack;
	}
	
	private void callTickEvent(){
		for(EventAction e : eventsTick){
			e.eventCalled(new Object[]{
				this	
			});
		}
	}
	
	public void updateEntity(){
        if(worldObj.getWorldTime() % 100 == 0){
        	callTickEvent();
        }
    }
	
	@Override
	public ItemStack getStackInSlotOnClosing(int par1){
        if (this.inventory[par1] != null)
        {
            ItemStack itemstack = this.inventory[par1];
            this.inventory[par1] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		inventory[i] = itemstack;
	}

	@Override
	public String getInvName() {
		return "inventory.magiccharger";
	}

	@Override
	public boolean isInvNameLocalized() {
		return true;
	}
	
	/**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
        this.inventory = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;

            if (j >= 0 && j < this.inventory.length && !isInSaveBlackList(j))
            {
                this.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
        this.upgradeLevel = par1NBTTagCompound.getInteger("UpgradeLvl");
    }
    
    private int[] saveBlackList = { 4 };
    
    private boolean isInSaveBlackList(int id){
    	for (int i = 0; i < this.inventory.length; i++){
    		try{
	    		if(saveBlackList[i] == id){
	    			return true;
	    		}
    		}
    		catch(Exception e){
    			
    		}
    	}
    	return false;
    }
    
    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.inventory.length; ++i)
        {
            if (this.inventory[i] != null && !isInSaveBlackList(i))
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.inventory[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        par1NBTTagCompound.setTag("Items", nbttaglist);
        par1NBTTagCompound.setInteger("UpgradeLvl", upgradeLevel);
    }
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer){
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

	@Override
	public void openChest() { }

	@Override
	public void closeChest() { }

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}

	public int getLevel() {
		return upgradeLevel;
	}

}
