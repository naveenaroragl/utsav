/**
 *
 */
package gl.utsav.vendor.dto;

import java.io.Serializable;

import gl.utsav.vendor.enums.GLUVendorType;


/**
 *
 */
public class VendorData implements Serializable
{
	private String vendorId;

	private GLUVendorType type;

	private String email;

	private String phone;

	private String uridomain;

	/**
	 * @return the type
	 */
	public GLUVendorType getType()
	{
		return type;
	}

	/**
	 * @param type
	 *           the type to set
	 */
	public void setType(final GLUVendorType type)
	{
		this.type = type;
	}

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @return the vendorId
	 */
	public String getVendorId()
	{
		return vendorId;
	}

	/**
	 * @param vendorId
	 *           the vendorId to set
	 */
	public void setVendorId(final String vendorId)
	{
		this.vendorId = vendorId;
	}

	/**
	 * @param email
	 *           the email to set
	 */
	public void setEmail(final String email)
	{
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone()
	{
		return phone;
	}

	/**
	 * @param phone
	 *           the phone to set
	 */
	public void setPhone(final String phone)
	{
		this.phone = phone;
	}

	/**
	 * @return the uridomain
	 */
	public String getUridomain()
	{
		return uridomain;
	}

	/**
	 * @param uridomain
	 *           the uridomain to set
	 */
	public void setUridomain(final String uridomain)
	{
		this.uridomain = uridomain;
	}
}
