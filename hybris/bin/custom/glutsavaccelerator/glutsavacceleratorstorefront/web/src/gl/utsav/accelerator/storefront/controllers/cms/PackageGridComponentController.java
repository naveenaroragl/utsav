
package gl.utsav.accelerator.storefront.controllers.cms;

import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commercefacades.product.data.CategoryData;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gl.utsav.accelerator.core.model.CategoryGridComponentModel;
import gl.utsav.accelerator.facades.category.GLCategoryFacade;
import gl.utsav.accelerator.storefront.controllers.ControllerConstants;


/**
 * Controller for CMS ProductReferencesComponent.
 */
@Controller("PackageGridComponentController")
@Scope("tenant")
@RequestMapping(value = ControllerConstants.Actions.Cms.PackageGridComponent)
public class PackageGridComponentController extends AbstractCMSComponentController<CategoryGridComponentModel>
{
	@Resource(name = "glCategoryFacade")
	private GLCategoryFacade glCategoryFacade;

	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final CategoryGridComponentModel component)
	{
		final List<CategoryData> categories = new ArrayList<>();

		categories.addAll(collectCategories(component));

		model.addAttribute("numberOfCategories", component.getNumberOfCategories());
		model.addAttribute("categoryData", categories);
	}

	protected List<CategoryData> collectCategories(final CategoryGridComponentModel component)
	{
		final List<CategoryData> categories = new ArrayList<>();

		for (final CategoryModel categoryModel : component.getCategoryItemsList())
		{
			categories.add(glCategoryFacade.getCategoryData(categoryModel));
		}

		return categories;
	}


}
