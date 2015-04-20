package com.whammich.sstow.events;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;

import com.whammich.sstow.item.ItemShardSoul;
import com.whammich.sstow.utils.TierHandler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class AnvilShardEvent {

	@SubscribeEvent
	public void handleAnvilStuff(AnvilUpdateEvent event) {
		
		byte leftTier = event.left.stackTagCompound.getByte("Tier");
		byte rightTier = event.right.stackTagCompound.getByte("Tier");
		short killResult = (short) (event.left.stackTagCompound.getShort("KillCount")
				+ event.right.stackTagCompound.getShort("KillCount"));
		
		// If the slots are empty, do nothing
		if(event.left == null || event.right == null){
			return;
		}
		
		// If the left and right slots are soul shards proceed
		if(event.left.getItem() instanceof ItemShardSoul && event.right.getItem() instanceof ItemShardSoul) {
			
			// Is the left input tier higher than the right tier?
			if(leftTier >= rightTier || leftTier <= rightTier) {
							
				// Set and copy the right slot into a new instance
				ItemStack targetStack = event.right;
				ItemStack resultStack = targetStack.copy();

				// Set the kill count NBT with the killResult variable
				resultStack.stackTagCompound.setShort("KillCount", killResult);

				// Set the tier based on kill count
				resultStack.stackTagCompound.setByte("Tier", TierHandler.getCorrectTier(resultStack));
								
				// Tag the anvil shard with the cheater boolean (I will change this to a string)
				resultStack.stackTagCompound.setBoolean("Anviled", true);
				
				// Place the combined shard in the result slot
				event.output = resultStack;
				
				// Charge the player 30 XP levels
				event.cost = 30;
			}
		}
	}
}