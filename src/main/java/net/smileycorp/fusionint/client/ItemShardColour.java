package net.smileycorp.fusionint.client;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.smileycorp.fusionint.common.fusion.ItemClumps;

public class ItemShardColour implements IItemColor {

	@Override
	public int colorMultiplier(ItemStack stack, int tintIndex) {
		return ((ItemClumps)stack.getItem()).getColour();
	}

}