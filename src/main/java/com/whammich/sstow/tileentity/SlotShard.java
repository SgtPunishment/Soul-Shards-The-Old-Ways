package com.whammich.sstow.tileentity;

import com.whammich.sstow.utils.Register;
import com.whammich.sstow.utils.Utils;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotShard  extends Slot
{

    public SlotShard(IInventory parIInventory, int parSlotIndex, 
          int parXDisplayPosition, int parYDisplayPosition)
    {
        super(parIInventory, parSlotIndex, parXDisplayPosition, 
              parYDisplayPosition);
    }
    
    @Override
	public boolean isItemValid(ItemStack stack) {
		return (stack.getItem() == Register.ItemShardSoul
				  && stack.getItem() == Register.ItemShardSoul 
				  && Utils.isShardBound(stack) 
				  && Utils.getShardTier(stack) > 0 );
	}
}