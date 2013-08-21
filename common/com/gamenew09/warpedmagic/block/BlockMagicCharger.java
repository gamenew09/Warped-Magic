package com.gamenew09.warpedmagic.block;

import com.gamenew09.warpedmagic.tileentity.TileEntityMagicCharger;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMagicCharger extends BlockContainer {

	protected BlockMagicCharger(int par1) {
		super(par1, Material.wood);
		setHardness(2.0F);
		setStepSound(soundWoodFootstep);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMagicCharger();
	}

}
