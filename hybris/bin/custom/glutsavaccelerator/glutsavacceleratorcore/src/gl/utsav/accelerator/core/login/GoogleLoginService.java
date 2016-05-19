/**
 *
 */
package gl.utsav.accelerator.core.login;

import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;


/**
 * @author nidhi.singh1
 *
 */
public interface GoogleLoginService
{
	public String authRequest(final String code) throws CMSItemNotFoundException;
}

