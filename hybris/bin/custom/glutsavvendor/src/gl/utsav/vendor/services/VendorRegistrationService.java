/**
 *
 */
package gl.utsav.vendor.services;

import de.hybris.platform.jalo.security.JaloSecurityException;

import javax.servlet.http.HttpServletRequest;

import gl.utsav.vendor.dto.VendorCompanyData;
import gl.utsav.vendor.dto.VendorData;
import gl.utsav.vendor.dto.VendorUserData;
import gl.utsav.vendor.model.GLUVendorCompanyModel;
import gl.utsav.vendor.model.GLUVendorModel;
import gl.utsav.vendor.model.GLUVendorUserModel;



/**
 *
 */
public interface VendorRegistrationService
{
	public GLUVendorCompanyModel createVendorCompany(VendorCompanyData data);

	public GLUVendorModel registerVendor(GLUVendorCompanyModel company, VendorData data);

	public GLUVendorUserModel registerVendorUser(GLUVendorModel vendor, VendorUserData data);

	public void setVendorCompanyContact(GLUVendorCompanyModel company, GLUVendorUserModel contact);

	/**
	 * @param userName
	 * @param password
	 * @param request
	 * @return
	 * @throws JaloSecurityException
	 */
	public boolean validateAndCreateSession(String userName, String password, HttpServletRequest request)
			throws JaloSecurityException;

}
