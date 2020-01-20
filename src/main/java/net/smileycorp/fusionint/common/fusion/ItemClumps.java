package net.smileycorp.fusionint.common.fusion;

import alexndr.api.registry.ContentCategories;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.translation.I18n;
import net.smileycorp.fusionint.common.ModDefinitions;

public class ItemClumps extends Item {
	
	final String name;
	final int colour; 
	
	static String[] types = {"small", "medium", "large"};

	public ItemClumps(String name, int colour) {
		this.setCreativeTab(ContentCategories.CreativeTab.GENERAL.vanillaTab);
		this.setRegistryName(ModDefinitions.getResource(name+"_Chunk"));
		this.setUnlocalizedName(ModDefinitions.getName(name+"_Chunk"));
		this.name=name;
		this.colour=colour;
	}
	
	@Override
	public void getSubItems(CreativeTabs tabs, NonNullList<ItemStack> itemList) {
		if(!isInCreativeTab(tabs)) return;
		for(int counter = 0; counter < types.length; counter++) {
			itemList.add(new ItemStack(this, 1, counter));
		}
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		int meta = stack.getItemDamage();
		String name = types[meta];
		return getDisplayName(name);
	}
	
	private String getDisplayName(String name) {
		String result = I18n.translateToLocal("localisation." + name).trim();
		result += " ";
		result += I18n.translateToLocal("localisation." + this.name.toLowerCase()).trim();
		result += " ";
		result += I18n.translateToLocal("localisation.chunk").trim();
		return result;
	}
	
	public int getColour() {
		return colour;
	}
}
