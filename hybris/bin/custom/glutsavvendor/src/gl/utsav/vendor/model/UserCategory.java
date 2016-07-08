/**
 *
 */
package gl.utsav.vendor.model;

/**
 * @author Deepak.J
 *
 */
public class UserCategory
{
	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	public UserCategory(final int id, final String name)
	{
		super();
		this.id = id;
		this.name = name;
	}

	private final int id;
	private final String name;

	//Setters and Getters

	@Override
	public String toString()
	{
		return "UserCategory [id=" + id + ", name=" + name + "]";
	}
}