/**
 *
 */
package gl.utsav.accelerator.facade.login.impl;

import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;

import org.springframework.beans.factory.annotation.Required;

import gl.utsav.accelerator.core.login.GoogleLoginService;
import gl.utsav.accelerator.facade.login.GoogleLoginFacade;


/**
 * @author devendra.singh
 *
 */
public class DefaultGoogleLoginFacade implements GoogleLoginFacade
{
	
	
	
	private GoogleLoginService googleLoginService;
	
	@Required
	public void setGoogleLoginService(final GoogleLoginService googleLoginService)
	{
		this.googleLoginService = googleLoginService;
	}
	

	protected GoogleLoginService getGoogleLoginService()
	{
		return googleLoginService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gl.utsav.accelerator.core.login.GoogleLoginFacade#authRequest(java.lang.String)
	 */
	@Override
	public String authRequest(final String code) throws CMSItemNotFoundException
	{
		return getGoogleLoginService().authRequest(code);
	}

}
