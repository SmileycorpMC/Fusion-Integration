package net.smileycorp.fusionint.common.tcon;

import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.shared.TinkerCommons;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.smileycorp.fusionint.common.ModDefinitions;
import net.smileycorp.fusionint.common.fluids.FusionFluids;
import net.smileycorp.fusionint.common.fusion.FusionContent;

public class TConRecipes {

	public static void addRecipes(IForgeRegistry<IRecipe> registry) {
		GameRegistry.addShapelessRecipe(ModDefinitions.getResource("small_manyullyn"), ModDefinitions.getResource("shards"),
				new ItemStack(FusionContent.MANYULLYN, 1, 2), Ingredient.fromStacks(new ItemStack(FusionContent.MANYULLYN, 1, 0)),
						Ingredient.fromStacks(new ItemStack(FusionContent.MANYULLYN, 1, 0)), Ingredient.fromStacks(new ItemStack(FusionContent.MANYULLYN, 1, 0)),
							Ingredient.fromStacks(new ItemStack(FusionContent.MANYULLYN, 1, 0)), Ingredient.fromStacks(new ItemStack(FusionContent.MANYULLYN, 1, 0)));
		GameRegistry.addShapelessRecipe(ModDefinitions.getResource("medium_manyullyn"), ModDefinitions.getResource("shards"),
				new ItemStack(FusionContent.MANYULLYN, 1, 2), Ingredient.fromStacks(new ItemStack(FusionContent.MANYULLYN, 1, 1)),
				Ingredient.fromStacks(new ItemStack(FusionContent.MANYULLYN, 1, 1)),Ingredient.fromStacks(new ItemStack(FusionContent.MANYULLYN, 1, 1)));
		
		GameRegistry.addSmelting(new ItemStack(FusionContent.MANYULLYN, 1, 2), TinkerCommons.ingotManyullyn.copy(), 12f);
		
	}
	
}
