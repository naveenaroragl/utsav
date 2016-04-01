package gl.utsav.accelerator.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractLoginPageController;
import de.hybris.platform.acceleratorstorefrontcommons.forms.ForgottenPwdForm;
import de.hybris.platform.acceleratorstorefrontcommons.security.AutoLoginStrategy;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.user.data.RegisterData;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.core.GenericSearchConstants.LOG;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import gl.utsav.accelerator.facade.login.GoogleLoginFacade;
import gl.utsav.accelerator.facades.user.data.GoogleData;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import gl.utsav.accelerator.storefront.controllers.ControllerConstants;


@Controller
@RequestMapping(value = "/loginGoogle")
public class LogInGoogleController extends AbstractLoginPageController
{

	@Resource(name = "autoLoginStrategy")
	private AutoLoginStrategy autoLoginStrategy;


	@Resource(name = "googleLoginFacade")
	private GoogleLoginFacade googleLoginFacade;

	private HttpSessionRequestCache httpSessionRequestCache;

	private static final long serialVersionUID = 1L;

	public LogInGoogleController()
	{
		super();

	}

	protected GoogleLoginFacade getGoogleLoginFacade()
	{
		return googleLoginFacade;
	}


	/**
	 * @return the autoLoginStrategy
	 */

	@Override
	protected AutoLoginStrategy getAutoLoginStrategy()
	{
		return autoLoginStrategy;
	}

	@Resource(name = "httpSessionRequestCache")
	public void setHttpSessionRequestCache(final HttpSessionRequestCache accHttpSessionRequestCache)
	{
		this.httpSessionRequestCache = accHttpSessionRequestCache;
	}



	@RequestMapping(value = "/submit", method = RequestMethod.GET)
	void sendRequest(final String code) throws Exception
	{
		//
	}

	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public String getPasswordRequest(@RequestParam("code") final String code, final Model model, final HttpServletRequest request,
			final HttpServletResponse response, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		final GoogleData userDetails = new Gson().fromJson(getGoogleLoginFacade().authRequest(code), GoogleData.class);

		final RegisterData data = new RegisterData();
		data.setFirstName(userDetails.getGiven_name());
		data.setLastName(userDetails.getFamily_name());
		data.setLogin(userDetails.getEmail());
		data.setPassword("temp"); //
		data.setTitleCode("mr");

		try
		{
			getCustomerFacade().register(data);
			getAutoLoginStrategy().login(userDetails.getEmail(), "temp", request, response);
		}
		catch (final DuplicateUidException e)
		{
			getAutoLoginStrategy().login(userDetails.getEmail(), "temp", request, response);
			LOG.warn("User Already registered!! " + e);
			System.out.println("Error print " + e);
		}

		return REDIRECT_PREFIX + getSuccessRedirect(request, response);//Password.PasswordResetRequestPopup;

	}

	@RequestMapping(value = "/request", method = RequestMethod.POST)
	public String passwordRequest(@Valid final ForgottenPwdForm form, final BindingResult bindingResult, final Model model)
			throws CMSItemNotFoundException
	{
		if (bindingResult.hasErrors())
		{
			return ControllerConstants.Views.Fragments.Google.GoogleLoginForm;
		}
		else
		{
			try
			{
				//	customerFacade.forgottenPassword(form.getEmail());
			}
			catch (final UnknownIdentifierException unknownIdentifierException)
			{
				//	LOG.warn("Email: " + form.getEmail() + " does not exist in the database.");
			}
			return ControllerConstants.Views.Fragments.Password.ForgotPasswordValidationMessage;
		}
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractRegisterPageController#getCmsPage()
	 */
	@Override
	protected AbstractPageModel getCmsPage() throws CMSItemNotFoundException
	{
		// YTODO Auto-generated method stub
		return null;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractRegisterPageController#getSuccessRedirect
	 * (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected String getSuccessRedirect(final HttpServletRequest request, final HttpServletResponse response)
	{
		if (httpSessionRequestCache.getRequest(request, response) != null)
		{
			return httpSessionRequestCache.getRequest(request, response).getRedirectUrl();
		}
		return "/";
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractRegisterPageController#getView()
	 */
	@Override
	protected String getView()
	{
		// YTODO Auto-generated method stub
		return null;
	}
}