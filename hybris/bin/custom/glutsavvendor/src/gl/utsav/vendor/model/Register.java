/**
 *
 */
package gl.utsav.vendor.model;

import java.util.List;

import gl.utsav.vendor.dto.VendorUserData;
import gl.utsav.vendor.enums.GLUVendorType;


/**
 * @author Deepak.J
 *
 */
public class Register
{
	private VendorUserData data;
	private List<GLUVendorType> gluVendorTypes;

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

	/**
	 * @return the data
	 */
	public VendorUserData getData()
	{
		return data;
	}

	/**
	 * @param data
	 *           the data to set
	 */
	public void setData(final VendorUserData data)
	{
		this.data = data;
	}


}
