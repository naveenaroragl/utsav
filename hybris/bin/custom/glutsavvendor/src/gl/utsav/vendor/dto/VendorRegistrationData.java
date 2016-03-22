/**
 *
 */
package gl.utsav.vendor.dto;

import java.io.Serializable;


/**
 *
 */
public class VendorRegistrationData implements Serializable
{
	private VendorCompanyData companyData;

	private VendorData vendorData;

	private VendorUserData userData;



	/**
	 * @return the companyData
	 */
	public VendorCompanyData getCompanyData()
	{
		return companyData;
	}

	/**
	 * @param companyData
	 *           the companyData to set
	 */
	public void setCompanyData(final VendorCompanyData companyData)
	{
		this.companyData = companyData;
	}

	/**
	 * @return the vendorData
	 */
	public VendorData getVendorData()
	{
		return vendorData;
	}

	/**
	 * @param vendorData
	 *           the vendorData to set
	 */
	public void setVendorData(final VendorData vendorData)
	{
		this.vendorData = vendorData;
	}

	/**
	 * @return the userData
	 */
	public VendorUserData getUserData()
	{
		return userData;
	}

	/**
	 * @param userData
	 *           the userData to set
	 */
	public void setUserData(final VendorUserData userData)
	{
		this.userData = userData;
	}


}
