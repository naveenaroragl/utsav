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
package gl.utsav.accelerator.storefront.commonabstract.controllers.pages;

import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;

import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import gl.utsav.accelerator.storefront.breadcrumb.Breadcrumb;
import gl.utsav.accelerator.storefront.commonabstract.controllers.ThirdPartyConstants;
import gl.utsav.accelerator.storefront.commonabstract.controllers.util.GlobalMessages;
import gl.utsav.accelerator.storefront.forms.GuestForm;
import gl.utsav.accelerator.storefront.forms.LoginForm;
import gl.utsav.accelerator.storefront.forms.RegisterForm;


/**
 * Abstract base class for login page controllers
 */
public abstract class AbstractLoginPageController extends AbstractRegisterPageController
{
	protected static final String SPRING_SECURITY_LAST_USERNAME = "SPRING_SECURITY_LAST_USERNAME";

	protected String getDefaultLoginPage(final boolean loginError, final HttpSession session, final Model model)
			throws CMSItemNotFoundException
	{
		final LoginForm loginForm = new LoginForm();
		model.addAttribute(loginForm);
		model.addAttribute(new RegisterForm());
		model.addAttribute(new GuestForm());

		final String username = (String) session.getAttribute(SPRING_SECURITY_LAST_USERNAME);
		if (username != null)
		{
			session.removeAttribute(SPRING_SECURITY_LAST_USERNAME);
		}

		loginForm.setJ_username(username);
		storeCmsPageInModel(model, getCmsPage());
		setUpMetaDataForContentPage(model, (ContentPageModel) getCmsPage());
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.INDEX_NOFOLLOW);

		final Breadcrumb loginBreadcrumbEntry = new Breadcrumb("#", getMessageSource().getMessage("header.link.login", null,
				"header.link.login", getI18nService().getCurrentLocale()), null);
		model.addAttribute("breadcrumbs", Collections.singletonList(loginBreadcrumbEntry));

		if (loginError)
		{
			model.addAttribute("loginError", Boolean.valueOf(loginError));
			GlobalMessages.addErrorMessage(model, "login.error.account.not.found.title");
		}

		return getView();
	}
}
