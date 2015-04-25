package com.whammich.sstow.guihandler;

import com.whammich.sstow.utils.Register;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotModule extends Slot {

	public SlotModule(IInventory parIInventory, int parSlotIndex,
			int parXDisplayPosition, int parYDisplayPosition) {
		super(parIInventory, parSlotIndex, parXDisplayPosition,
				parYDisplayPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return (stack.getItem() == Register.ItemModules);
	}
}