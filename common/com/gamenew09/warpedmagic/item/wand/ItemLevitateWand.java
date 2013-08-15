package com.gamenew09.warpedmagic.item.wand;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLevitateWand extends ItemBaseWand {

	public ItemLevitateWand(int par1, int onUseDamageAmount) {
		super(par1, onUseDamageAmount);
		this.setMaxDamage(250);
	}

	@Override
	public boolean doWandAction(ItemStack stack, EntityPlayer player, World world, int X, int Y, int Z, int side, float hitX, float hitY, float hitZ) {
		if(player.isCollided){
			stack.damageItem(onUseDamageAmount, player);
			player.setPosition(player.posX, player.posY + 10, player.posZ);
			world.spawnParticle("smoke", player.posX, player.posY, player.posZ, 0, 2, 0);
			return true;
		}
		return false;
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer player)
    {
		boolean a = false;
		if(player.isCollided){
			player.setPosition(player.posX, player.posY + 10, player.posZ);
			world.spawnParticle("smoke", player.posX, player.posY, player.posZ, 0, 2, 0);
			a = true;
		}
		if(a){
			par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() - this.onUseDamageAmount);
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

}
