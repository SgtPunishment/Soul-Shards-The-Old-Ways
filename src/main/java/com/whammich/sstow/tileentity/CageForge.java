package com.whammich.sstow.tileentity;

import com.whammich.sstow.utils.SFRecipeHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CageForge extends Container {
	private TileEntityCage tileCage;

	public CageForge(InventoryPlayer player, TileEntityCage tileEntityCage) {
		this.tileCage = tileEntityCage;
		this.addSlotToContainer(new Slot(tileEntityCage, 0, 56, 17));
		this.addSlotToContainer(new Slot(tileEntityCage, 1, 56, 53));
		
		int i;
		for (i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
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

	public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
		
		ItemStack itemstack = null;
		
		Slot slot = (Slot) this.inventorySlots.get(par2);
		
		if (slot != null && slot.getHasStack()) {
			
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (par2 == 2) {
				
				if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
					return null;
				}
				
				slot.onSlotChange(itemstack1, itemstack);
				
			} else if (par2 != 1 && par2 != 0) {
				
				if (SFRecipeHandler.smelting().getSmeltingResult(itemstack1) != null) {
					
					if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
						return null;
					}
					
				} else if (TileEntityForge.isItemFuel(itemstack1)) {
					
					if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
						return null;
					}
					
				} else if (par2 >= 3 && par2 < 30) {
					if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
						return null;
					}
				} else if (par2 >= 30 && par2 < 39
						
						&& !this.mergeItemStack(itemstack1, 3, 30, false)) {
					return null;
				}
				
			} else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
				return null;
			}
			
			if (itemstack1.stackSize == 0) {
				
				slot.putStack((ItemStack) null);
				
			} else {
				
				slot.onSlotChanged();
				
			}
			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}
			
			slot.onPickupFromSlot(player, itemstack1);
			
		}
		return itemstack;
	}
}