/**
 *
 */
package gl.utsav.vendor.dto;

import de.hybris.platform.commercefacades.user.data.AddressData;

import java.io.Serializable;


/**
 *
 */
public class VendorUserData implements Serializable
{
	private String userId;

	private String firstName;
	private String lastName;
	private String email;
	private AddressData mailingAddress;
	private String password;

	/**
	 * @return the firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}


	/**
	 * @return the userId
	 */
	public String getUserId()
	{
		return userId;
	}


	/**
	 * @param userId
	 *           the userId to set
	 */
	public void setUserId(final String userId)
	{
		this.userId = userId;
	}


	/**
	 * @param firstName
	 *           the firstName to set
	 */
	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * @param lastName
	 *           the lastName to set
	 */
	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
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
	 * @return the mailingAddress
	 */
	public AddressData getMailingAddress()
	{
		return mailingAddress;
	}

	/**
	 * @param mailingAddress
	 *           the mailingAddress to set
	 */
	public void setMailingAddress(final AddressData mailingAddress)
	{
		this.mailingAddress = mailingAddress;
	}

	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param password
	 *           the password to set
	 */
	public void setPassword(final String password)
	{
		this.password = password;
	}


}
