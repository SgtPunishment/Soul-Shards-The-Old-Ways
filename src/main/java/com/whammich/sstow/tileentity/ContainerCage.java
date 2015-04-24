package com.whammich.sstow.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCage extends Container {
	private TileEntityCage tileCage;

	public ContainerCage(InventoryPlayer player, TileEntityCage TileEntityCage) {
		this.tileCage = TileEntityCage;
		this.addSlotToContainer(new SlotShard(TileEntityCage, 0, 17, 17));
		this.addSlotToContainer(new SlotModule(TileEntityCage, 1, 36, 17));
		this.addSlotToContainer(new SlotLocked(TileEntityCage, 2, 70, 17));
		this.addSlotToContainer(new SlotLocked(TileEntityCage, 3, 88, 17));
		this.addSlotToContainer(new SlotLocked(TileEntityCage, 4, 106, 17));
		this.addSlotToContainer(new SlotLocked(TileEntityCage, 5, 124, 17));
		this.addSlotToContainer(new SlotLocked(TileEntityCage, 6, 152, 17));

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
	
	 @Override
     public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
             ItemStack stack = null;
             Slot slotObject = (Slot) inventorySlots.get(slot);

             if (slotObject != null && slotObject.getHasStack()) {
                     ItemStack stackInSlot = slotObject.getStack();
                     stack = stackInSlot.copy();

                     
                     if (slot < 6) {
                             if (!this.mergeItemStack(stackInSlot, 6, 43, true)) {
                                     return null;
                             }
                     } else if (slot >= 6 && slot < 34) {
     					if (!this.mergeItemStack(stackInSlot, 30, 39, false)) {
    						return null;
    					}
    				} else if (slot >= 34 && slot < 43
    						
    						&& !this.mergeItemStack(stackInSlot, 6, 34, false)) {
    					return null;
    				}
                     else if (!this.mergeItemStack(stackInSlot, 6, 43, false)) {
                             return null;
                     }

                     if (stackInSlot.stackSize == 0) {
                             slotObject.putStack(null);
                     } else {
                             slotObject.onSlotChanged();
                     }

                     if (stackInSlot.stackSize == stack.stackSize) {
                             return null;
                     }
                     slotObject.onPickupFromSlot(player, stackInSlot);
             }
             return stack;
     }
}