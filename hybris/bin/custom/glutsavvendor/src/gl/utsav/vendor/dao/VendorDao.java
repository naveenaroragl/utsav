/**
 *
 */
package gl.utsav.vendor.dao;

import java.util.List;

import gl.utsav.vendor.model.GLUVendorModel;
import gl.utsav.vendor.model.GLUVendorUserModel;


/**
 *
 */
public interface VendorDao
{

	public GLUVendorModel getVendor(String vendorId);

	public List<GLUVendorUserModel> findUsers(String companayId);

}
