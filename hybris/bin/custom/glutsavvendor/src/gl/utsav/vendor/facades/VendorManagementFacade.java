/**
 *
 */
package gl.utsav.vendor.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gl.utsav.vendor.dto.VendorRegistrationData;
import gl.utsav.vendor.model.GLUVendorCompanyModel;
import gl.utsav.vendor.model.GLUVendorModel;
import gl.utsav.vendor.model.GLUVendorUserModel;
import gl.utsav.vendor.services.VendorRegistrationService;


/**
 *
 */
@Component(value = "gluVendorManagementFacade")
public class VendorManagementFacade
{

	@Autowired
	private VendorRegistrationService gluVendorRegistrationService;


	public VendorRegistrationData registerVendor(final VendorRegistrationData data)
	{
		//TODO validate input

		final GLUVendorCompanyModel companyModel = gluVendorRegistrationService.createVendorCompany(data.getCompanyData());
		data.getCompanyData().setCompanyId(companyModel.getPk().toString());

		final GLUVendorModel vendorModel = gluVendorRegistrationService.registerVendor(companyModel, data.getVendorData());
		data.getVendorData().setVendorId(vendorModel.getPk().toString());

		final GLUVendorUserModel userModel = gluVendorRegistrationService.registerVendorUser(vendorModel, data.getUserData());
		data.getUserData().setUserId(userModel.getUid());

		gluVendorRegistrationService.setVendorCompanyContact(companyModel, userModel);
		return data;
	}
}
