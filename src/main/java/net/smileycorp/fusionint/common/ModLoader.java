package net.smileycorp.fusionint.common;

import net.minecraftforge.fml.common.Loader;
import net.smileycorp.fusionint.common.tcon.TConRegistry;

public class ModLoader {
	
	public static boolean useFluids;

	public static void readMods() {
		if (Loader.isModLoaded("embers")) {
			useFluids = true;
		}
		if (Loader.isModLoaded("tconstruct")) {
			useFluids = true;
		}
		
	}

	public static void initMods() {
		if (Loader.isModLoaded("tconstruct")) {
			TConRegistry.registerMaterials();
			TConRegistry.registerSmeltery();
		}
		
	}

}
