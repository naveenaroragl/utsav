/**
 *
 */
package gl.utsav.vendor.dto;

import java.io.Serializable;
import java.util.List;

import gl.utsav.vendor.enums.GLUVendorType;


/**
 *
 */
public class VendorRegistrationData implements Serializable
{
	private VendorCompanyData companyData;

	private VendorData vendorData;

	private VendorUserData userData;

	private List<GLUVendorType> gluVendorTypes;



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


	/**
	 * @return the gluVendorTypes
	 */
	public List<GLUVendorType> getGluVendorTypes()
	{
		return gluVendorTypes;
	}

	/**
	 * @param gluVendorTypes
	 *           the gluVendorTypes to set
	 */
	public void setGluVendorTypes(final List<GLUVendorType> gluVendorTypes)
	{
		this.gluVendorTypes = gluVendorTypes;
	}


}
