package com.gamenew09.warpedmagic.item.wand;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemLevitateWand extends ItemBaseWand {

	public ItemLevitateWand(int par1, int onUseDamageAmount) {
		super(par1, onUseDamageAmount);
		//this.setMaxDamage(250);
	}

	@Override
	public boolean doWandAction(ItemStack stack, EntityPlayer player, World world, int X, int Y, int Z, int side, float hitX, float hitY, float hitZ) {
		//if(player.isCollided && decItemStackByItem(player, new ItemStack(Item.coal, 2))){
		//	stack.damageItem(onUseDamageAmount, player);
		//	player.setPosition(player.posX, player.posY + 10, player.posZ);
		//	world.spawnParticle("smoke", player.posX, player.posY, player.posZ, 0, 2, 0);
		//	stack.damageItem(2, player);
		//	return true;
		//}
		return false;
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int X, int Y, int Z, int side, float hitX, float hitY, float hitZ){
		return false;
	}
	
	/**
	 * Decrement ItemStack found by one.
	 * @param player = The Player
	 * @param itemstack - Item, stackSize is removal and minimal.
	 */
	private boolean decItemStackByItem(EntityPlayer player, ItemStack itemstack){
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
	
	public String getItemDisplayName(ItemStack itemStack){
		return EnumChatFormatting.GOLD + super.getItemDisplayName(itemStack);
	}
	
	@SuppressWarnings("static-access")
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer player)
    {
		if((player.isCollidedVertically || getLevelByMetaData(par1ItemStack) >= 2) && !player.isCollidedHorizontally && decItemStackByItem(player, new ItemStack(Item.coal))){
			player.setPosition(player.posX, player.posY + (5 * (getLevelByMetaData(par1ItemStack))), player.posZ);
			for (int i = 0; i < 32; ++i)
	        {
	            world.spawnParticle("portal", player.posX, player.posY + this.itemRand.nextDouble() * .6D, player.posZ, this.itemRand.nextGaussian(), 0.0D, this.itemRand.nextGaussian());
	        }
		}
		return par1ItemStack;
    }
	
	public boolean hasEffect(ItemStack par1ItemStack, int pass){
		return true;
	}
	
	public void registerIcons(IconRegister ir){
		this.itemIcon = ir.registerIcon("wmm:wand-levit");
	}
	
	public EnumRarity getRarity(ItemStack is){ //The colour of the item name (eg. with golden apples)
		return EnumRarity.epic;
	}
	
	public boolean hasEffect(){
		return true;
	}
	
	@Override
	public int getBurnTime(ItemStack s) {
		return 5000;
	}

	@Override
	public int getMaxWandLevel() {
		return 4;
	}

}
