package com.whammich.sstow.guihandler;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotLocked extends Slot {
	@SuppressWarnings("unused")
	private int[] damage = new int[9];

	public SlotLocked(IInventory parIInventory, int parSlotIndex,
			int parXDisplayPosition, int parYDisplayPosition/* , int damage */) {
		super(parIInventory, parSlotIndex, parXDisplayPosition,
				parYDisplayPosition);
		// this.damage[damage] = parSlotIndex;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;
	}

	public boolean showSelectionBox = false;
}