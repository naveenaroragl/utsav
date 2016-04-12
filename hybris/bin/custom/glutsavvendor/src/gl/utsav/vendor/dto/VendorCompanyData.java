/**
 *
 */
package gl.utsav.vendor.dto;

import de.hybris.platform.commercefacades.user.data.AddressData;

import java.io.Serializable;


/**
 *
 */
public class VendorCompanyData implements Serializable
{

	private String companyId;

	private String companyName;

	private String description;

	private AddressData Address;


	/**
	 * @return the companyId
	 */
	public String getCompanyId()
	{
		return companyId;
	}

	/**
	 * @param companyId
	 *           the companyId to set
	 */
	public void setCompanyId(final String companyId)
	{
		this.companyId = companyId;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName()
	{
		return companyName;
	}

	/**
	 * @param companyName
	 *           the companyName to set
	 */
	public void setCompanyName(final String companyName)
	{
		this.companyName = companyName;
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description
	 *           the description to set
	 */
	public void setDescription(final String description)
	{
		this.description = description;
	}



	/**
	 * @return the address
	 */
	public AddressData getAddress()
	{
		return Address;
	}

	/**
	 * @param address
	 *           the address to set
	 */
	public void setAddress(final AddressData address)
	{
		Address = address;
	}





}
