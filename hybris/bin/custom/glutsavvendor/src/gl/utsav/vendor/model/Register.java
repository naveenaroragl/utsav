/**
 *
 */
package gl.utsav.vendor.model;

import javax.validation.constraints.NotNull;


/**
 * @author Deepak.J
 *
 */
public class Register
{
	private String userName;
	private String email;

	/**
	 * @return the userCategory
	 */
	public UserCategory getUserCategory()
	{
		return userCategory;
	}

	/**
	 * @param userCategory
	 *           the userCategory to set
	 */
	public void setUserCategory(final UserCategory userCategory)
	{
		this.userCategory = userCategory;
	}

	private String password;
	@NotNull
	private UserCategory userCategory;

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

	/**
	 * @return the name
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * @param name
	 *           the name to set
	 */
	public void setUserName(final String name)
	{
		this.userName = name;
	}

}
