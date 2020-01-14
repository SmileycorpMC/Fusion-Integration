package net.smileycorp.fusionint.common.tcon;

import static alexndr.plugins.Fusion.ModItems.*;
import static alexndr.plugins.SimpleOres.ModItems.*;
import static net.smileycorp.fusionint.common.tcon.TConRegistry.ADAMANTIUM;
import static net.smileycorp.fusionint.common.tcon.TConRegistry.MYTHRIL;
import static net.smileycorp.fusionint.common.tcon.TConRegistry.ONYX;
import static net.smileycorp.fusionint.common.tcon.TConRegistry.SINISITE;
import static net.smileycorp.fusionint.common.tcon.TConRegistry.THYRIUM;
import alexndr.plugins.SimpleOres.ModBlocks;
import alexndr.plugins.SimpleOres.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.IForgeRegistry;
import net.smileycorp.fusionint.common.fluids.FusionFluids;
import net.smileycorp.fusionint.common.fusion.FusionContent;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.shared.TinkerFluids;
import slimeknights.tconstruct.tools.TinkerTools;

public class TConRegistry {
	
	public static Material ADAMANTIUM;
	public static Material MYTHRIL;
	public static Material ONYX;
	public static Material THYRIUM;
	public static Material SINISITE;
	
	public static MaterialIntegration ADAMANTIUM_INT;
	public static MaterialIntegration MYTHRIL_INT;
	public static MaterialIntegration ONYX_INT;
	public static MaterialIntegration THYRIUM_INT;
	public static MaterialIntegration SINISITE_INT;

	public static void registerMaterials() {
		ADAMANTIUM = new Material("adamantium", 0xFF45B350);
		ADAMANTIUM.addCommonItems("Adamantium");
		
		MYTHRIL = new Material("mythril", 0xFF459BF1);
		MYTHRIL.addCommonItems("Mythril");
		
		
		ONYX = new Material("onyx", 0xFF333333);
		ONYX.addCommonItems("Onyx");
		ONYX.addItem(ModItems.onyx_gem, 1, 1);
		ONYX.addItem(ModBlocks.onyx_block, 9);
		
		THYRIUM = new Material("thyrium", 0xFF1A1A81);
		THYRIUM.addCommonItems("Thyrium");
		
		
		SINISITE = new Material("sinisite", 0xFF52AB94);
		SINISITE.addCommonItems("Sinisite");
		
		
	}
	
	public static void registerSmeltery() {
		//alloys
		TinkerRegistry.registerAlloy(new FluidStack(FusionFluids.THYRIUM, 1), new FluidStack(FusionFluids.ADAMANTIUM, 1), new FluidStack(FusionFluids.MYTHRIL, 1));
		
		//melting chunks
		TinkerRegistry.registerMelting(large_bronze_chunk, TinkerFluids.bronze, 288);
		TinkerRegistry.registerMelting(large_steel_chunk, TinkerFluids.steel, 288);
		TinkerRegistry.registerMelting(large_thyrium_chunk, FusionFluids.THYRIUM, 288);
		TinkerRegistry.registerMelting(large_sinisite_chunk, FusionFluids.SINISITE, 288);
		TinkerRegistry.registerMelting(new ItemStack(FusionContent.MANYULLYN, 1, 0), TinkerFluids.manyullyn, 288);
		
		//melting rods
		TinkerRegistry.registerMelting(mythril_rod, FusionFluids.MYTHRIL, 288);
		TinkerRegistry.registerMelting(thyrium_rod, FusionFluids.THYRIUM, 288);
		TinkerRegistry.registerMelting(sinisite_rod, FusionFluids.SINISITE, 288);
	}
	
	public static void registerTools() {
		
	}

	public static void registerIntergrations(IForgeRegistry<IRecipe> registry) {
		ADAMANTIUM_INT=TinkerRegistry.integrate(ADAMANTIUM, FusionFluids.ADAMANTIUM, "Adamantium");
		ADAMANTIUM_INT.toolforge();
		ADAMANTIUM_INT.registerToolForgeRecipe(registry);
		
		MYTHRIL_INT=TinkerRegistry.integrate(MYTHRIL, FusionFluids.MYTHRIL, "Mythril");
		MYTHRIL_INT.toolforge();
		MYTHRIL_INT.registerToolForgeRecipe(registry);
		
		ONYX_INT = TinkerRegistry.integrate(ONYX, "Onyx");
		ONYX_INT.toolforge();
		ONYX_INT.registerToolForgeRecipe(registry);
		ONYX_INT.setRepresentativeItem("gemOnyx");
		
		THYRIUM_INT = TinkerRegistry.integrate(THYRIUM, FusionFluids.THYRIUM, "Thyrium");
		THYRIUM_INT.toolforge();
		THYRIUM_INT.registerToolForgeRecipe(registry);
		
		SINISITE_INT = TinkerRegistry.integrate(SINISITE, FusionFluids.SINISITE, "Sinisite");
		SINISITE_INT.toolforge();
		SINISITE_INT.registerToolForgeRecipe(registry);
		
	}

}
