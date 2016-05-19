/**
 *
 */
package gl.utsav.accelerator.facades.login;

import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;


/**
 * @author nidhi.singh1
 *
 */
public interface GoogleLoginFacade
{
	public String authRequest(final String code) throws CMSItemNotFoundException;
}
