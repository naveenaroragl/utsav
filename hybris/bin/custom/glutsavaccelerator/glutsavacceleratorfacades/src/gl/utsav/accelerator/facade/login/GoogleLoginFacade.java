/**
 *
 */
package gl.utsav.accelerator.facade.login;

import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;


/**
 * @author devendra.singh
 *
 */
public interface GoogleLoginFacade
{

	public String authRequest(final String code) throws CMSItemNotFoundException;



}
