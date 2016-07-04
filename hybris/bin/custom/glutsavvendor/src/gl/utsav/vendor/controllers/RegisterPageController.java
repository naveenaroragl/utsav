/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package gl.utsav.vendor.controllers;

import de.hybris.platform.category.CategoryService;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.classification.ClassificationService;
import de.hybris.platform.classification.ClassificationSystemService;
import de.hybris.platform.classification.features.FeatureList;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.site.CMSSiteModel;
import de.hybris.platform.cms2.servicelayer.services.CMSSiteService;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commerceservices.product.CommerceProductService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.jalo.security.JaloSecurityException;
import de.hybris.platform.product.ProductService;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gl.utsav.vendor.dto.ItemDetailData;
import gl.utsav.vendor.dto.VendorRegistrationData;
import gl.utsav.vendor.enums.GLUVendorType;
import gl.utsav.vendor.facades.VendorManagementFacade;
import gl.utsav.vendor.forms.ProductForm;
import gl.utsav.vendor.validator.VendorValidator;



/**
 * Register Controller for mobile. Handles login and register for the account flow.
 */
@Controller
public class RegisterPageController
{
	@Autowired
	VendorValidator validator;

	@Resource
	private VendorManagementFacade gluVendorManagementFacade;

	@Resource
	private CategoryService categoryService;

	@Resource
	private ClassificationService classificationService;

	@Resource
	private CommerceProductService commerceProductService;

	@Resource
	private ProductService productService;

	@Resource
	private ProductFacade productFacade;

	@Resource
	private ClassificationSystemService classificationSystemService;

	@Resource
	private CMSSiteService cmsSiteService;

	private ProductModel dummy;

	@RequestMapping(method = RequestMethod.GET)
	public String getLandingPage(final Model model)
	{
		model.addAttribute("register", new VendorRegistrationData());
		return "register";
	}

	@RequestMapping(method = RequestMethod.GET, value = "logout")
	public String logout(final HttpServletRequest request, final HttpServletResponse response, final Model model)
	{
		final HttpSession session = request.getSession(false);

		if (session != null)
		{
			session.invalidate();
		}

		model.addAttribute("register", new VendorRegistrationData());
		return "redirect:fetchFeatures";
	}



	@RequestMapping(method = RequestMethod.GET, value = "home")
	public String getHomePage(final Model model, final HttpServletRequest request) throws CMSItemNotFoundException
	{

		final CMSSiteModel cmsSite = (cmsSiteService.getSites()).iterator().next();
		cmsSiteService.setCurrentSiteAndCatalogVersions(cmsSite, true);
		final Collection<CategoryModel> categories = categoryService
				.getRootCategoriesForCatalogVersion(cmsSiteService.getCurrentCatalogVersion());
		final ProductForm productForm = new ProductForm();
		model.addAttribute("productForm", productForm);
		model.addAttribute("categories", categories);
		return "categoryRegistration";
	}

	@ModelAttribute("gluVendorTypes")
	public List<GLUVendorType> populateDepartments()
	{
		final List<GLUVendorType> categories = Arrays.asList(GLUVendorType.values());
		return categories;
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String doRegister(final VendorRegistrationData registrationData, final Model model)
	{
		registrationData.getVendorData().setEmail(registrationData.getUserData().getEmail());
		registrationData.getVendorData().setPhone(registrationData.getUserData().getMailingAddress().getPhone());
		final AddressData d = registrationData.getUserData().getMailingAddress();
		registrationData.getCompanyData().setAddress(d);
		gluVendorManagementFacade.registerVendor(registrationData);
		model.addAttribute("register", registrationData);
		return "register";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String doLogin(final VendorRegistrationData registrationData, final Model model, final RedirectAttributes redirectModel,
			final BindingResult result, final HttpServletRequest request) throws JaloSecurityException
	{
		final String username = registrationData.getUserData().getEmail();
		final String pwd = registrationData.getUserData().getPassword();
		//Validation code
		validator.validate(registrationData, result);

		if (!result.hasErrors())
		{
			System.out.println(username);
			System.out.println(pwd);
			final boolean isValidUser = gluVendorManagementFacade.validateAndCreateSession(username, pwd, request);
			if (isValidUser)
			{
				final HttpSession session = request.getSession(true);
				redirectModel.addFlashAttribute("user", session.getAttribute("user"));
				return "redirect:home";
			}
		}
		model.addAttribute("register", new VendorRegistrationData());
		return "register";
	}

	@RequestMapping(value = "fetchFeatures", method = RequestMethod.GET)
	public String createProductForm(String category, final Model model)
	{
		category = "Necklace";
		final List<ProductModel> products = productService.getProductsForCategory(categoryService.getCategoryForCode(category));
		products.forEach(product -> {
			System.out.println(product);
			if (product.getCode().contains("J100"))
			{
				dummy = product;
			}
		});


		final FeatureList features = classificationService.getFeatures(dummy);
		model.addAttribute("features", features.getClassificationClasses());
		model.addAttribute("productData", new ProductData());
		return "createProduct";
	}


	@RequestMapping(value = "createProduct", method = RequestMethod.POST)
	public String createProduct(final ProductForm productForm, final Model model)
	{

		return "confirm";
	}

	@RequestMapping(value = "fetchSubCategories", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> fetchSubCategories(final String categoryName, final Model model)
	{
		final CategoryModel category = categoryService.getCategoryForCode(categoryName);
		final Map<String, String> subcategoryList = new HashMap<String, String>();
		final Collection<CategoryModel> subcategories = category.getAllSubcategories();
		if (!subcategories.isEmpty())
		{
			subcategories.forEach(subCategory -> {
				subcategoryList.put(subCategory.getCode(), subCategory.getName());
			});
		}
		return subcategoryList;
	}

	@RequestMapping(value = "renderCategoryListingPage", method = RequestMethod.POST)
	public String categoryListing(final Model model)
	{

		model.addAttribute("itemDetailData", new ItemDetailData());
		return "category";
	}

	@RequestMapping(value = "CategoryListing", method = RequestMethod.POST)
	public String getcategoryListing(@ModelAttribute("itemDetailData") final ItemDetailData itemDetailData, final Model model,
			final HttpServletRequest request, final BindingResult result)
	{

		model.addAttribute("itemDetailData", new ItemDetailData());
		return "category";
	}

}
