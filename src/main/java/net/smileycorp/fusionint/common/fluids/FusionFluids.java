package net.smileycorp.fusionint.common.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.smileycorp.fusionint.common.ModDefinitions;
import net.smileycorp.fusionint.common.ModLoader;

public class FusionFluids {
	
	public static BlockFluidMolten ADAMANTIUM_BLOCK;
	public static FluidMolten ADAMANTIUM = new FluidMolten("adamantium", 765, 0xFF45B350, EnumRarity.UNCOMMON, ADAMANTIUM_BLOCK);
	
	public static BlockFluidMolten MYTHRIL_BLOCK;
	public static FluidMolten MYTHRIL = new FluidMolten("mythril", 880, 0xFF459BF1, EnumRarity.UNCOMMON, MYTHRIL_BLOCK);
	
	public static BlockFluidMolten ONYX_BLOCK;
	public static FluidMolten ONYX = new FluidMolten("onyx", 900, 0xFF333333, EnumRarity.RARE, ONYX_BLOCK);
	
	public static BlockFluidMolten SINISITE_BLOCK;
	public static FluidMolten SINISITE = new FluidMolten("sinisite", 870, 0xFF1A1A81, EnumRarity.EPIC, SINISITE_BLOCK);
	
	public static BlockFluidMolten THYRIUM_BLOCK;
	public static FluidMolten THYRIUM = new FluidMolten("thyrium", 880, 0xFF52AB94, EnumRarity.RARE, THYRIUM_BLOCK);
	
	
	//public static Block;
	
	static FluidMolten[] MOLTEN_FLUIDS = {ADAMANTIUM, MYTHRIL, SINISITE, THYRIUM};
	
	@EventBusSubscriber(modid=ModDefinitions.MODID)
	public static class FluidRegister {
		
		@SubscribeEvent
		public static void registerFluids(RegistryEvent.Register<Block> event) {
			if (Loader.isModLoaded("simpleores")) {
				for (Fluid fluid : MOLTEN_FLUIDS) {
					FluidRegistry.registerFluid(fluid);
					FluidRegistry.addBucketForFluid(fluid);
					ModDefinitions.log("Registered fluid " +fluid.getName());
				}

				ADAMANTIUM_BLOCK = new BlockFluidMolten(ADAMANTIUM, MapColor.GREEN);
				event.getRegistry().register(ADAMANTIUM_BLOCK);
				
				MYTHRIL_BLOCK = new BlockFluidMolten(MYTHRIL, MapColor.BLUE);
				event.getRegistry().register(MYTHRIL_BLOCK);
				
				SINISITE_BLOCK = new BlockFluidMolten(SINISITE, MapColor.LAPIS);
				event.getRegistry().register(SINISITE_BLOCK);
				
				THYRIUM_BLOCK = new BlockFluidMolten(THYRIUM, MapColor.CYAN);
				event.getRegistry().register(THYRIUM_BLOCK);
			} else {
				ModDefinitions.log("Skipping fluid registry, Simple Ores not loaded.");
			}
		}
		
		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent event) {
			for(FluidMolten fluid : MOLTEN_FLUIDS) {
				if(fluid == null) {
				      return;
			    }
				Block block = fluid.getBlock();
			    if(block != null) {
			      Item item = Item.getItemFromBlock(block);
			      
			      final ModelResourceLocation location = new ModelResourceLocation(ModDefinitions.getResource("fluid_molten"), block.getRegistryName().getResourcePath());
			      
			      StateMapperFluid mapper = new StateMapperFluid(fluid, location);
			      
			      if(item != Items.AIR) {
			        ModelLoader.registerItemVariants(item);
			        ModelLoader.setCustomMeshDefinition(item, mapper);
			      }
			      
			      ModelLoader.setCustomStateMapper(block, mapper);
			    }

			}
		}
	}
}
