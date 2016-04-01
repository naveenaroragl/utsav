/**
 *
 */
package gl.utsav.accelerator.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author devendra.singh
 *
 */
@Controller
@RequestMapping(value = "/loginFacebook")
public class LogInFacebookController extends AbstractPageController
{


	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public String getPasswordRequest(@RequestParam("code") final String code, final Model model) throws CMSItemNotFoundException
	{

		System.out.println("Entering into request.");

		System.out.println("Entering into request." + code);

		final String acctoken = getAccessToken(code);

		System.out.println("Ac====================================================" + acctoken);
		getFBGraph(acctoken);

		System.out.println("entering doGet");

		return "/";
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
				in = new BufferedReader(new InputStreamReader(fbConnection.getInputStream()));
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

		fbGraphUrl = "https://graph.facebook.com/oauth/access_token?" + "client_id=" + "531112010392992" + "&redirect_uri="
				+ "https://localhost:9002/glutsavacceleratorstorefront/en/loginFacebook/request" + "&client_secret="
				+ "535d025d21ade97db4754ce88174d0ad" + "&code=" + code;

		System.out.println(fbGraphUrl);
		return fbGraphUrl;
	}


}
