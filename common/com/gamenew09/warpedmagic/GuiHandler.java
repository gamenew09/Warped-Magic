package com.gamenew09.warpedmagic;

import com.gamenew09.warpedmagic.gui.inventory.*;
import com.gamenew09.warpedmagic.inventory.*;
import com.gamenew09.warpedmagic.tileentity.*;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if(tileEntity instanceof TileEntityMagicCharger){
                    return new ContainerMagicCharger(player.inventory, (TileEntityMagicCharger) tileEntity);
            }
            return null;
    }

    //returns an instance of the Gui you made earlier
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if(tileEntity instanceof TileEntityMagicCharger){
                    return new GuiMagicCharger(player.inventory, (TileEntityMagicCharger) tileEntity);
            }
            return null;

    }

}
