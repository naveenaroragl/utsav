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

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gl.utsav.vendor.model.Register;
import gl.utsav.vendor.model.UserCategory;


/**
 * Register Controller for mobile. Handles login and register for the account flow.
 */
@Controller
public class RegisterPageController
{

	@RequestMapping(method = RequestMethod.GET)
	public String getLandingPage(final Model model)
	{
		model.addAttribute("register", new Register());
		return "register";
	}

	@ModelAttribute("userCategories")
	public List<UserCategory> populateDepartments()
	{
		final ArrayList<UserCategory> categories = new ArrayList<UserCategory>();
		categories.add(new UserCategory(1, "Sole proprietorship"));
		categories.add(new UserCategory(2, "Private Ltd company"));
		categories.add(new UserCategory(3, "LLP/Partnership firm"));
		return categories;
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String doRegister(final Model model)
	{
		return "register";
	}
}
