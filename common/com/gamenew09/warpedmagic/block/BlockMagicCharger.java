package com.gamenew09.warpedmagic.block;

import com.gamenew09.warpedmagic.WarpedMagicMod;
import com.gamenew09.warpedmagic.tileentity.TileEntityMagicCharger;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMagicCharger extends BlockContainer {

	public BlockMagicCharger(int par1) {
		super(par1, Material.wood);
		setHardness(2.0F);
		setStepSound(soundWoodFootstep);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i1, float f1, float f2, float f3){
		player.openGui(WarpedMagicMod.instance, 0, world, x, y, z);
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMagicCharger();
	}

}
