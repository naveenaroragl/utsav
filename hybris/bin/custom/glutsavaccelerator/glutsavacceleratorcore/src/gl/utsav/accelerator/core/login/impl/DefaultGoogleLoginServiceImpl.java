/**
 *
 */
package gl.utsav.accelerator.core.login.impl;

import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import gl.utsav.accelerator.core.login.GoogleLoginService;


/**
 * @author nidhi.singh1
 *
 */
public class DefaultGoogleLoginServiceImpl implements GoogleLoginService
{
	public static final String CLIENT_ID = "838327630667-4s7visper5eq9i1okkukcmt09518c0p5.apps.googleusercontent.com";

	public static final String CLIENT_SECRET = "z1g6eSSZxLSzJFDCKBkXpMM9";

	public static final String REDIRECT_URI = "https://localhost:9002/glutsavacceleratorstorefront/en/loginGoogle/request";

	public static final String GRANT_TYPE = "authorization_code";


	@Override
	public String authRequest(final String code) throws CMSItemNotFoundException
	{
		String line, outputString = "";
		try
		{

			URL url = new URL("https://accounts.google.com/o/oauth2/token");
			URLConnection urlConn = url.openConnection();
			urlConn.setDoOutput(true);
			final OutputStreamWriter writer = new OutputStreamWriter(urlConn.getOutputStream());
			writer.write(getUrlParameters(code));
			writer.flush();

			BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			while ((line = reader.readLine()) != null)
			{
				outputString += line;
			}


			final JsonObject json = (JsonObject) new JsonParser().parse(outputString);
			final String access_token = json.get("access_token").getAsString();

			url = new URL("https://www.googleapis.com/oauth2/v2/userinfo?access_token=" + access_token);
			urlConn = url.openConnection();
			outputString = "";
			reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			while ((line = reader.readLine()) != null)
			{
				outputString += line;
			}

			writer.close();
			reader.close();

		}
		catch (final MalformedURLException e)
		{
			System.out.println(e);
		}
		catch (final ProtocolException e)
		{
			System.out.println(e);
		}
		catch (final IOException e)
		{
			System.out.println(e);
		}

		return outputString;

	}


	public String getUrlParameters(final String code)
	{

		final String urlParameters = "code=" + code + "&client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET
				+ "&redirect_uri=" + REDIRECT_URI + "&grant_type=" + GRANT_TYPE;

		return urlParameters;
	}

}
