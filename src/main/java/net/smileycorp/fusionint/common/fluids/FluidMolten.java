package net.smileycorp.fusionint.common.fluids;

import java.awt.Color;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.smileycorp.fusionint.common.ModDefinitions;

public class FluidMolten extends Fluid {

	public FluidMolten(String name, int temp, int colour, EnumRarity rarity, BlockFluidMolten block) {
		super(name, ModDefinitions.getResource("blocks/molten_metal"), ModDefinitions.getResource("blocks/molten_metal_flow"), colour);
		this.setUnlocalizedName(ModDefinitions.getName(name));
		this.setTemperature(temp);
		this.setRarity(rarity);
		this.setDensity(2000);
	    this.setViscosity(10000);
	    this.setLuminosity(10); 
	    this.setGaseous(false);
	    this.setBlock(block);
	}

}
