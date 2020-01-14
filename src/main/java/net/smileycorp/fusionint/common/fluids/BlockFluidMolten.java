package net.smileycorp.fusionint.common.fluids;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;
import net.smileycorp.fusionint.common.ModDefinitions;

public class BlockFluidMolten extends BlockFluidFinite {

	public BlockFluidMolten(Fluid fluid, MapColor colour) {
		super(fluid, Material.LAVA, colour);
		this.setRegistryName(ModDefinitions.getResource("molten_" + fluid.getName()));
		this.setUnlocalizedName(ModDefinitions.getName("molten_" + fluid.getName()));
	}

}
