package com.gamenew09.warpedmagic.item.wand;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLevitateWand extends ItemBaseWand {

	public ItemLevitateWand(int par1, int onUseDamageAmount) {
		super(par1, onUseDamageAmount);
	}

	@Override
	public boolean doWandAction(ItemStack stack, EntityPlayer player, World world, int X, int Y, int Z, int side, float hitX, float hitY, float hitZ) {
		player.setPosition(player.posX, player.posY + 10, player.posZ);
		world.spawnParticle("smoke", player.posX, player.posY, player.posZ, 0, 2, 0);
		return true;
	}
	
	public EnumRarity getRarity(ItemStack is){ //The colour of the item name (eg. with golden apples)
		return EnumRarity.epic;
	}

}
