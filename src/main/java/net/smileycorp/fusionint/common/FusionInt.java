package net.smileycorp.fusionint.common;

import alexndr.api.registry.Plugin;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.smileycorp.fusionint.common.fluids.FusionFluids;
import net.smileycorp.fusionint.common.fusion.FusionContent;
import net.smileycorp.fusionint.common.fusion.FusionRecipes;

@Mod(modid=ModDefinitions.MODID, name=ModDefinitions.NAME, version=ModDefinitions.VESRION, dependencies = "required-after:fusion")
public class FusionInt {
	
	@Instance(ModDefinitions.MODID)
	public static FusionInt INSTANCE;
	public static Plugin plugin = new Plugin(ModDefinitions.MODID, ModDefinitions.NAME);
	
	public FusionInt() {
		INSTANCE=this;
		FluidRegistry.enableUniversalBucket();
		ModDefinitions.log("Enabled bucket.");
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ModLoader.readMods();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		ModLoader.initMods();
		FusionRecipes.addRecipes();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
}
