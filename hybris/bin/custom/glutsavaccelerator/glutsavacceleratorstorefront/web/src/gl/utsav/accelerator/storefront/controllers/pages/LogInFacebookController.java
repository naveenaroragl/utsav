/**
 *
 */
package gl.utsav.accelerator.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractLoginPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author nidhi.singh1
 *
 */
@Controller
@RequestMapping(value = "/en/loginFacebook")
public class LogInFacebookController extends AbstractLoginPageController
{
	@Resource(name = "httpSessionRequestCache")
	private HttpSessionRequestCache httpSessionRequestCache;

	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public String getPasswordRequest(@RequestParam("code") final String code, final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws CMSItemNotFoundException
	{
		System.out.println("Entering into request." + code);
		final String acctoken = getAccessToken(code);
		System.out.println("Ac====================================================" + acctoken);
		getFBGraph(acctoken);
		System.out.println("entering doGet");
		return REDIRECT_PREFIX + getSuccessRedirect(request, response);
	}


	public String getFBGraph(final String accessToken)
	{
		String graph = null;
		try
		{

			final String g = "https://graph.facebook.com/me?" + accessToken;
			final URL u = new URL(g);
			final URLConnection c = u.openConnection();
			final BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
			String inputLine;
			final StringBuffer b = new StringBuffer();
			while ((inputLine = in.readLine()) != null)
			{
				b.append(inputLine + "\n");
			}
			in.close();
			graph = b.toString();
			System.out.println(graph);
		}
		catch (final Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException("ERROR in getting FB graph data. " + e);
		}
		return graph;
	}





	public String getAccessToken(final String code)
	{
		String accessToken = "";
		if ("".equals(accessToken))
		{
			URL fbGraphURL;
			try
			{
				fbGraphURL = new URL(getFBGraphUrl(code));
			}
			catch (final MalformedURLException e)
			{
				e.printStackTrace();
				throw new RuntimeException("Invalid code received " + e);
			}
			URLConnection fbConnection;
			StringBuffer b = null;
			try
			{
				fbConnection = fbGraphURL.openConnection();
				BufferedReader in;
				//				in = new BufferedReader(new InputStreamReader(fbConnection.getInputStream()));
				in = new BufferedReader(new InputStreamReader(fbConnection.getInputStream(), Charset.forName("UTF-8")));
				String inputLine;
				b = new StringBuffer();
				while ((inputLine = in.readLine()) != null)
				{
					b.append(inputLine + "\n");
				}
				in.close();
			}
			catch (final IOException e)
			{
				e.printStackTrace();
				throw new RuntimeException("Unable to connect with Facebook " + e);
			}

			accessToken = b.toString();
			if (accessToken.startsWith("{"))
			{
				throw new RuntimeException("ERROR: Access Token Invalid: " + accessToken);
			}
		}
		return accessToken;
	}

	public String getFBGraphUrl(final String code)
	{
		String fbGraphUrl = "";

		fbGraphUrl = "https://graph.facebook.com/oauth/access_token?" + "client_id=" + "1622586648064129" + "&redirect_uri="
				+ "https://localhost:9002/glutsavacceleratorstorefront/en/loginFacebook/request" + "&client_secret="
				+ "56ea51ca3def86611d5ad4b26967d0d1" + "&code=" + code;

		System.out.println(fbGraphUrl);
		return fbGraphUrl;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractRegisterPageController#
	 * getSuccessRedirect (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
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
	 * @see de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractRegisterPageController#getView()
	 */
	@Override
	protected String getView()
	{
		// YTODO Auto-generated method stub
		return null;
	}


}