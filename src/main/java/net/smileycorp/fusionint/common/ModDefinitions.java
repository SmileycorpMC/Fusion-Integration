package net.smileycorp.fusionint.common;

import net.minecraft.util.ResourceLocation;

public class ModDefinitions {
	public static final String MODID = "fusionint";
	public static final String NAME = "Fusion Intergrations";
	public static final String VESRION = "alpha 1.1a";
	
	public static final String location = "net.smileycorp.fusionint.";
	public static final String client = location + "client.ClientProxy";
	
	public static String getName(String name) {
		return ModDefinitions.MODID + "." + name.replace("_", "");
	}

	public static ResourceLocation getResource(String name) {
		return new ResourceLocation(MODID, name);
	}

	public static void log(String string) {
		System.out.println("["+MODID+"]"+ string + ".");
	}
}
