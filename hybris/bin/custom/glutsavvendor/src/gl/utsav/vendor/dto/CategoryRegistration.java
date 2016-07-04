package gl.utsav.vendor.dto;

import java.util.ArrayList;
import java.util.List;


public class CategoryRegistration
{

	private String category;

	private List<String> categories = new ArrayList<String>();

	private List<String> subcategories = new ArrayList<String>();

	/**
	 * @param subcategories
	 *           the subcategories to set
	 */
	public void setSubcategories(final List<String> subcategories)
	{
		this.subcategories = subcategories;
	}

	/**
	 * @return the subcategories
	 */
	public List<String> getSubcategories()
	{
		return subcategories;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(final String category)
	{
		this.category = category;
	}

	public List<String> getCategories()
	{
		return categories;
	}

	public void setCategories(final List<String> categories)
	{
		this.categories = categories;
	}

}
