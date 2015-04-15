package com.whammich.sstow.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerCage extends Container {
	private TileEntityCage tileCage;

	public ContainerCage(InventoryPlayer player, TileEntityCage TileEntityCage) {
		this.tileCage = TileEntityCage;
		this.addSlotToContainer(new Slot(TileEntityCage, 0, 17, 17));
		this.addSlotToContainer(new Slot(TileEntityCage, 1, 98, 17));
		this.addSlotToContainer(new Slot(TileEntityCage, 2, 116, 17));
		this.addSlotToContainer(new Slot(TileEntityCage, 3, 134, 17));
		this.addSlotToContainer(new Slot(TileEntityCage, 4, 152, 17));

		int i;
		for (i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(player, j + i * 9 + 9,
						8 + j * 18, 84 + i * 18));
			}
		}

		for (i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
		}

	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.tileCage.isUseableByPlayer(player);
	}
}