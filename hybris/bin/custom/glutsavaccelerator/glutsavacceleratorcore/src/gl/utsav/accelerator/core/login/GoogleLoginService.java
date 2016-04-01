/**
 *
 */
package gl.utsav.accelerator.core.login;

import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;


/**
 * @author devendra.singh
 *
 */
public interface GoogleLoginService
{

	public String authRequest(final String code) throws CMSItemNotFoundException;

}
