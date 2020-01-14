package net.smileycorp.fusionint.common.fusion;

import org.apache.commons.lang3.ArrayUtils;

import alexndr.api.content.items.SimpleItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.smileycorp.fusionint.common.FusionInt;
import net.smileycorp.fusionint.common.ModLoader;

@EventBusSubscriber
public class FusionContent {
	
	public static ItemClumps MANYULLYN = new ItemClumps("Manyullyn");
	
	public static ItemClumps[] ITEMS = {};
	private static ItemClumps[] TCON = {MANYULLYN};
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		if (ModLoader.tconLoaded) {
			ITEMS = ArrayUtils.addAll(ITEMS, TCON);
		}
		event.getRegistry().registerAll(ITEMS);
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void registerModels(ModelRegistryEvent event) {
		for (ItemClumps item : ITEMS) {
			for (int meta = 0; meta<3; meta++) {
				ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), item.types[meta]));
			}
		}
	}
}
