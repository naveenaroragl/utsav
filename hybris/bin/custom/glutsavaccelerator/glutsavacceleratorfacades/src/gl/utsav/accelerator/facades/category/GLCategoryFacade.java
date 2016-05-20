
package gl.utsav.accelerator.facades.category;

import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commercefacades.product.data.CategoryData;


/**
 * Facade to provide Category Data for a Category Model.
 */
public interface GLCategoryFacade
{
	CategoryData getCategoryData(CategoryModel categoryModel);

}
