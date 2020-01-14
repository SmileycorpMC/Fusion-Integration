package net.smileycorp.fusionint.common;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.smileycorp.fusionint.common.tcon.TConRecipes;
import net.smileycorp.fusionint.common.tcon.TConRegistry;

@EventBusSubscriber(modid=ModDefinitions.MODID)
public class RecipeRegistry {
	
	@SubscribeEvent
	public static void addRecipes(RegistryEvent.Register<IRecipe> event) {
		if (ModLoader.tconLoaded) {
			TConRecipes.addRecipes(event.getRegistry());
			TConRegistry.registerIntergrations(event.getRegistry());
		}
		
	}

}
