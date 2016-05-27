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

import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.jalo.security.JaloSecurityException;

import java.util.Arrays;
import java.util.List;

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

import gl.utsav.vendor.dto.VendorRegistrationData;
import gl.utsav.vendor.enums.GLUVendorType;
import gl.utsav.vendor.facades.VendorManagementFacade;
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
		return "redirect:home";
	}



	@RequestMapping(method = RequestMethod.GET, value = "home")
	public String getHomePage(final Model model)
	{
		//model.addAttribute("register", new VendorRegistrationData());
		return "index";
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
	public String doLogin(final VendorRegistrationData registrationData, final Model model, final BindingResult result,
			final HttpServletRequest request) throws JaloSecurityException
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
				return "redirect:home";
			}
		}
		model.addAttribute("register", new VendorRegistrationData());
		return "register";
	}
}
