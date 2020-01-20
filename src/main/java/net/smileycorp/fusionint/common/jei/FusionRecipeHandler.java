package net.smileycorp.fusionint.common.jei;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IRecipeWrapperFactory;
import mezz.jei.runtime.JeiHelpers;

public class FusionRecipeHandler /*implements IRecipeWrapperFactory<RecipeEntry>*/ {

	IJeiHelpers helpers;
	
	public FusionRecipeHandler(IJeiHelpers helpers) {
		this.helpers = helpers;
	}
	
	
	/*@Override
	public IRecipeWrapper getRecipeWrapper(RecipeEntry entry) {
		return new FusionRecipeWrapper(helpers, entry);
	}*/

}
