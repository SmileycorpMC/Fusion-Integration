package net.smileycorp.fusionint.common.fusion;

import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.lang3.ArrayUtils;

import alexndr.api.content.items.SimpleItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.smileycorp.fusionint.common.FusionInt;
import net.smileycorp.fusionint.common.ModDefinitions;

@EventBusSubscriber
public class FusionContent {
	private static HashMap<ItemClumps, String[]> OREDICT = new HashMap<ItemClumps, String[]>();
	
	//oredict
	public static ItemClumps BRASS = new ItemClumps("Brass", 0xFFE0C176);
	public static ItemClumps ALUBRASS = new ItemClumps("Alubrass", 0xFFE3BE50);
	public static ItemClumps CONSTANTAN = new ItemClumps("Constantan", 0xFFFFD37C);
	public static ItemClumps INVAR = new ItemClumps("Invar", 0xFFD0D7CE);
	public static ItemClumps ELECTRUM = new ItemClumps("Electrum", 0xFFFFF68A);
	
	//embers
	public static ItemClumps DAWNSTONE = new ItemClumps("Dawnstone", 0xFFE3B648);
	
	//tcon
	public static ItemClumps MANYULLYN = new ItemClumps("Manyullyn", 0xFFBD92F1);
	
	public static ItemClumps[] ITEMS = {};
	
	static {
		OREDICT.put(BRASS, new String[]{"Copper", "Zinc"});
		OREDICT.put(ALUBRASS, new String[]{"Copper", "Aluminum"});
		OREDICT.put(CONSTANTAN, new String[]{"Copper", "Nickel"});
		OREDICT.put(INVAR, new String[]{"Iron", "Nickel"});
		OREDICT.put(ELECTRUM, new String[]{"Silver", "Gold"});
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		for (Entry<ItemClumps, String[]> entry : OREDICT.entrySet()) {
			ItemClumps key = entry.getKey();
			String[] value = entry.getValue();
			if (nameExists(key.getUnlocalizedName().substring(14))&&nameExists(value[0])&&nameExists(value[1])) {
				ITEMS = ArrayUtils.add(ITEMS, key);
			}
		}
		if (Loader.isModLoaded("tconstruct")) {
			ITEMS = ArrayUtils.add(ITEMS, MANYULLYN);
		}
		if (Loader.isModLoaded("embers")) {
			ITEMS = ArrayUtils.add(ITEMS, DAWNSTONE);
		}
		event.getRegistry().registerAll(ITEMS);
	}
	
	static boolean nameExists(String name) {
		return OreDictionary.doesOreNameExist("ingot"+name.replace("_", ""));
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void registerModels(ModelRegistryEvent event) {
		for (ItemClumps item : ITEMS) {
			for (int meta = 0; meta<3; meta++) {
				ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(ModDefinitions.getResource("clumps"), item.types[meta]));
			}
		}
	}
}
