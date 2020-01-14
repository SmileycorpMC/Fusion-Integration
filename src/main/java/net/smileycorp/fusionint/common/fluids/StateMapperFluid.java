package net.smileycorp.fusionint.common.fluids;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

public class StateMapperFluid extends StateMapperBase implements
		ItemMeshDefinition {
	
	public final Fluid fluid;
    public final ModelResourceLocation location;

	public StateMapperFluid(FluidMolten fluid, ModelResourceLocation location) {
		this.fluid=fluid;
		this.location=location;
	}

	@Override
	public ModelResourceLocation getModelLocation(ItemStack stack) {
		// TODO Auto-generated method stub
		return location;
	}

	@Override
	protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
		// TODO Auto-generated method stub
		return location;
	}

}
