/**
 *
 */
package gl.utsav.accelerator.storefront.controllers.pages;

import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.commercefacades.user.data.RegisterData;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gl.utsav.accelerator.storefront.commonabstract.controllers.pages.AbstractLoginPageController;


/**
 * @author nidhi.singh1
 *
 */
@Controller
@RequestMapping(value = "/socialLogin")
public class SocialLoginController extends AbstractLoginPageController
{
	@Resource(name = "httpSessionRequestCache")
	private HttpSessionRequestCache httpSessionRequestCache;

	@RequestMapping(value = "/request", method = RequestMethod.POST)

	public String userLogin(@RequestParam("email") final String email, @RequestParam("name") final String name, final Model model,
			final HttpServletRequest request, final HttpServletResponse response) throws CMSItemNotFoundException
	{

		final RegisterData data = new RegisterData();
		data.setFirstName(StringUtils.substringBeforeLast(name, " "));
		data.setLastName(StringUtils.substringAfterLast(name, " "));
		data.setLogin(email);
		data.setPassword("temp");
		data.setTitleCode("mr");

		try
		{
			getCustomerFacade().register(data);
			getAutoLoginStrategy().login(email, "temp", request, response);
		}
		catch (final DuplicateUidException e)
		{
			getAutoLoginStrategy().login(email, "temp", request, response);
			LOG.warn("User Already registered!! " + e);
			System.out.println("Error print " + e);
		}
		return REDIRECT_PREFIX + getSuccessRedirect(request, response);//Password.PasswordResetRequestPopup;

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
	 * @see de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractRegisterPageController#
	 * getSuccessRedirect(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
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