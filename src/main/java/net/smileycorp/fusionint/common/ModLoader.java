package net.smileycorp.fusionint.common;

import net.minecraftforge.fml.common.Loader;
import net.smileycorp.fusionint.common.tcon.TConRegistry;

public class ModLoader {
	
	public static boolean embersLoaded;
	public static boolean tconLoaded;

	public static void readMods() {
		if (Loader.isModLoaded("embers")) {
			embersLoaded = true;
		}
		if (Loader.isModLoaded("tconstruct")) {
			tconLoaded = true;
			TConRegistry.registerMaterials();
		}
		
	}

	public static void initMods() {
		if (tconLoaded) {
			TConRegistry.registerSmeltery();
		}
		
	}

}
