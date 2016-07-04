package gl.utsav.vendor.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;



public class ItemDetailData
{

	private String title;
	private String subTitle;
	private String condition;
	private String brand;
	private String type;
	private String warrantyPartnerName;
	private String warrantyDetails;
	private String warrantyCondition;
	private String detail;
	private List<MultipartFile> files;

	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @param title
	 *           the title to set
	 */
	public void setTitle(final String title)
	{
		this.title = title;
	}

	/**
	 * @return the subTitle
	 */
	public String getSubTitle()
	{
		return subTitle;
	}

	/**
	 * @param subTitle
	 *           the subTitle to set
	 */
	public void setSubTitle(final String subTitle)
	{
		this.subTitle = subTitle;
	}

	/**
	 * @return the condition
	 */
	public String getCondition()
	{
		return condition;
	}

	/**
	 * @param condition
	 *           the condition to set
	 */
	public void setCondition(final String condition)
	{
		this.condition = condition;
	}

	/**
	 * @return the brand
	 */
	public String getBrand()
	{
		return brand;
	}

	/**
	 * @param brand
	 *           the brand to set
	 */
	public void setBrand(final String brand)
	{
		this.brand = brand;
	}

	/**
	 * @return the files
	 */
	public List<MultipartFile> getFiles()
	{
		return files;
	}

	/**
	 * @param files
	 *           the files to set
	 */
	public void setFiles(final List<MultipartFile> files)
	{
		this.files = files;
	}

	/**
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * @param type
	 *           the type to set
	 */
	public void setType(final String type)
	{
		this.type = type;
	}

	/**
	 * @return the warrantyPartnerName
	 */
	public String getWarrantyPartnerName()
	{
		return warrantyPartnerName;
	}

	/**
	 * @param warrantyPartnerName
	 *           the warrantyPartnerName to set
	 */
	public void setWarrantyPartnerName(final String warrantyPartnerName)
	{
		this.warrantyPartnerName = warrantyPartnerName;
	}

	/**
	 * @return the warrantyDetails
	 */
	public String getWarrantyDetails()
	{
		return warrantyDetails;
	}

	/**
	 * @param warrantyDetails
	 *           the warrantyDetails to set
	 */
	public void setWarrantyDetails(final String warrantyDetails)
	{
		this.warrantyDetails = warrantyDetails;
	}

	/**
	 * @return the warrantyCondition
	 */
	public String getWarrantyCondition()
	{
		return warrantyCondition;
	}

	/**
	 * @param warrantyCondition
	 *           the warrantyCondition to set
	 */
	public void setWarrantyCondition(final String warrantyCondition)
	{
		this.warrantyCondition = warrantyCondition;
	}

	/**
	 * @return the detail
	 */
	public String getDetail()
	{
		return detail;
	}

	/**
	 * @param detail
	 *           the detail to set
	 */
	public void setDetail(final String detail)
	{
		this.detail = detail;
	}

}
