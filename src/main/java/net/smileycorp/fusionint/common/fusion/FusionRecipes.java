package net.smileycorp.fusionint.common.fusion;

import slimeknights.tconstruct.shared.TinkerCommons;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.smileycorp.fusionint.common.ModLoader;
import alexndr.plugins.Fusion.Content;
import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import alexndr.plugins.Fusion.FusionMaterial;

public class FusionRecipes {

	public static void addRecipes() {
		if (ModLoader.tconLoaded) {
			//manyullyn
			FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotCobalt", 1), FusionMaterial.of("ingotArdite", 1),
					FusionMaterial.of("quartz", 1), new ItemStack(FusionContent.MANYULLYN, 1, 0), 10f);
			FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotCobalt", 1), FusionMaterial.of("ingotArdite", 1),
					FusionMaterial.of(Items.MAGMA_CREAM), new ItemStack(FusionContent.MANYULLYN, 1, 1), 18f);
			FusionFurnaceRecipes.addSmelting(FusionMaterial.of("ingotCobalt", 1), FusionMaterial.of("ingotArdite", 1),
					FusionMaterial.of(TinkerCommons.materials, 1, 11), new ItemStack(FusionContent.MANYULLYN, 1, 2), 54f);
		}
	}
	
}
