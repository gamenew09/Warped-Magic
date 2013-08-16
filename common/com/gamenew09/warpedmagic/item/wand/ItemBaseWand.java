package com.gamenew09.warpedmagic.item.wand;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public abstract class ItemBaseWand extends Item {

	protected int onUseDamageAmount;
	
	public ItemBaseWand(int par1, int onUseDamageAmount) {
		super(par1);
		this.setMaxStackSize(1);
		this.onUseDamageAmount = onUseDamageAmount;
	}
	
	public abstract int getBurnTime(ItemStack s);
	
	/**
	 * Decrement ItemStack found by one.
	 * @param player = The Player
	 * @param itemstack - Item, stackSize is removal and minimal.
	 */
	protected boolean decItemStackByItem(EntityPlayer player, ItemStack itemstack){
		if(player.capabilities.isCreativeMode) return true;
		for(int i = 0; i < player.inventory.mainInventory.length; i++){
			ItemStack is = player.inventory.mainInventory[i];
			if(is != null){
				if(is.itemID == itemstack.itemID && is.stackSize >= itemstack.stackSize && is.getItemDamage() == itemstack.getItemDamage()){
					is.stackSize -= itemstack.stackSize;
					player.inventory.mainInventory[i] = is;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Gets the max level of the wand.
	 * @return The level(1-int limit)
	 */
	public abstract int getMaxWandLevel();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List){
		 for (int j = 1; j <= getMaxWandLevel(); ++j)
	     {
			 par3List.add(new ItemStack(par1, 1, j - 1));
	     }
	}
	
	protected int getLevelByMetaData(ItemStack stack){
		return stack.getItemDamage() + 1;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(EnumChatFormatting.DARK_PURPLE + "Level "+getLevelByMetaData(par1ItemStack));
	}
	
	public abstract boolean doWandAction(ItemStack stack, EntityPlayer player, World world, int X, int Y, int Z, int side, float hitX, float hitY, float hitZ);
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int X, int Y, int Z, int side, float hitX, float hitY, float hitZ){
		boolean b = doWandAction(stack, player, world, X, Y, Z, side, hitX, hitY, hitZ);
		return b;
	}
	
}
