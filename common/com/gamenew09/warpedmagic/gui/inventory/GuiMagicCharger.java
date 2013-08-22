package com.gamenew09.warpedmagic.gui.inventory;

import org.lwjgl.opengl.GL11;

import com.gamenew09.warpedmagic.inventory.ContainerMagicCharger;
import com.gamenew09.warpedmagic.lib.Strings;
import com.gamenew09.warpedmagic.tileentity.TileEntityMagicCharger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.*;

public class GuiMagicCharger extends GuiContainer {
	
	public static final ResourceLocation texture = new ResourceLocation(com.gamenew09.warpedmagic.lib.Reference.MOD_ID.toLowerCase(), "textures/gui/magic-maker.png");
	
	public GuiMagicCharger(InventoryPlayer playerInv, TileEntityMagicCharger te) {
		super(new ContainerMagicCharger(playerInv, te));
	}

	@Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
            fontRenderer.drawString(Strings.INV_WANDFUELER_NAME, 8, 6, 4210752);
            fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft.getMinecraft().func_110434_K().func_110577_a(texture);
            int x = (width - xSize) / 2;
            int y = (height - ySize) / 2;
            this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }

}
