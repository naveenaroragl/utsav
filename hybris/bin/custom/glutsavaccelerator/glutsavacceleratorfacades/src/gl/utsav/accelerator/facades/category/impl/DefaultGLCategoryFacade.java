package gl.utsav.accelerator.facades.category.impl;

import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commercefacades.product.converters.populator.CategoryPopulator;
import de.hybris.platform.commercefacades.product.data.CategoryData;

import javax.annotation.Resource;

import gl.utsav.accelerator.facades.category.GLCategoryFacade;


/**
 * Facade to provide simple suggestions for a customer.
 */

public class DefaultGLCategoryFacade implements GLCategoryFacade
{

	/** Category Populator. */
	@Resource(name = "categoryPopulator")
	private CategoryPopulator categoryPopulator;

	@Override
	public CategoryData getCategoryData(final CategoryModel categoryModel)
	{
		if (categoryModel != null)
		{
			final CategoryData glCategoryData = new CategoryData();
			categoryPopulator.populate(categoryModel, glCategoryData);
			return glCategoryData;
		}
		return null;
	}

}
