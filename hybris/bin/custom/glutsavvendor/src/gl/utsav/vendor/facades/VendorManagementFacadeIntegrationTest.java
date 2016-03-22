/**
 *
 */
package gl.utsav.vendor.facades;

import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import gl.utsav.vendor.dto.VendorCompanyData;
import gl.utsav.vendor.dto.VendorData;
import gl.utsav.vendor.dto.VendorRegistrationData;
import gl.utsav.vendor.dto.VendorUserData;
import gl.utsav.vendor.enums.GLUVendorType;



/**
 *
 */

public class VendorManagementFacadeIntegrationTest extends ServicelayerTransactionalTest
{

	@Resource
	private VendorManagementFacade gluVendorManagementFacade;



	public VendorRegistrationData getRegistratonData()
	{

		final VendorCompanyData companyData = new VendorCompanyData();
		companyData.setCompanyName("ABC Ltd.");
		companyData.setDescription("ABC Ltd.");
		final AddressData companyAddress = new AddressData();
		companyAddress.setFirstName("ABC Company Ltd.");
		companyAddress.setLastName("");
		companyAddress.setLine1("H-10, Ocean Height");
		companyAddress.setLine2("Secotor-18");
		companyAddress.setTown("Noida");
		companyAddress.setPostalCode("201019");
		companyAddress.setPhone("+919818324574");
		companyData.setAddress(companyAddress);


		final VendorData vendorData = new VendorData();
		vendorData.setUridomain("abc");
		vendorData.setType(GLUVendorType.PRIVATELIMITEDCOMPANY);
		vendorData.setEmail("callabc@abc.com");
		vendorData.setPhone("+91212343646");

		final VendorUserData userData = new VendorUserData();
		userData.setFirstName("Ranjit");
		userData.setLastName("Singh");
		userData.setEmail("ranjit@abc.com");
		userData.setPassword("1234567");


		final VendorRegistrationData registrationData = new VendorRegistrationData();
		registrationData.setCompanyData(companyData);
		registrationData.setVendorData(vendorData);
		registrationData.setUserData(userData);

		return registrationData;
	}




	@Test
	public void testVenderRegistration()
	{
		VendorRegistrationData registrationData = getRegistratonData();

		registrationData = gluVendorManagementFacade.registerVendor(registrationData);

		Assert.assertNotNull(registrationData.getCompanyData().getCompanyId());
		Assert.assertNotNull(registrationData.getVendorData().getVendorId());
		Assert.assertEquals(registrationData.getUserData().getEmail(), registrationData.getUserData().getUserId());

	}

}
