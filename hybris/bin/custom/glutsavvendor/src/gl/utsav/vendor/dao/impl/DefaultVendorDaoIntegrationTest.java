/**
 *
 */
package gl.utsav.vendor.dao.impl;

import static org.junit.Assert.assertNotNull;

import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gl.utsav.vendor.dao.VendorDao;
import gl.utsav.vendor.enums.GLUVendorType;
import gl.utsav.vendor.model.GLUVendorCompanyModel;
import gl.utsav.vendor.model.GLUVendorModel;
import gl.utsav.vendor.model.GLUVendorUserModel;



/**
 *
 */
public class DefaultVendorDaoIntegrationTest extends ServicelayerTransactionalTest
{

	@Resource
	private VendorDao gluVendorDao;

	/** Platform's ModelService used for creation of test data. */
	@Resource
	private ModelService modelService;

	@Resource
	private final CommonI18NService commonI18NService = null;

	@Resource
	private final UserService userService = null;

	private GLUVendorModel newVendor = null;

	@Before
	public void setup()
	{

		final GLUVendorUserModel em = modelService.create(GLUVendorUserModel.class);
		em.setName("test user");
		em.setUid("myLogin@gmail.com");
		em.setSessionLanguage(commonI18NService.getCurrentLanguage());
		em.setSessionCurrency(commonI18NService.getCurrentCurrency());
		userService.setPassword(em, "test12334", "md5");


		final CountryModel cm = modelService.create(CountryModel.class);
		cm.setName("India");
		cm.setIsocode("IND");

		final AddressModel addr = modelService.create(AddressModel.class);
		addr.setFirstname("first toName");
		addr.setLastname("last toName");
		addr.setLine1("Address Line1");
		addr.setLine2("Address Line1");


		final GLUVendorCompanyModel company = modelService.create(GLUVendorCompanyModel.class);
		addr.setOwner(company);
		company.setUid("vendorgroup");
		company.setName("NCR Catters");
		company.setDescription("This is cattering company");
		company.setContact(em);
		//set Address
		company.setBillingAddress(addr);

		final Set set = new HashSet();
		set.add(company);
		em.setGroups(set);
		em.setCompany(company);

		final GLUVendorModel vendor = modelService.create(GLUVendorModel.class);
		vendor.setCode("default");
		vendor.setUridomain("ncrcatters");
		vendor.setVendorType(GLUVendorType.PRIVATELIMITEDCOMPANY);
		vendor.setEmail("test.email.com");
		vendor.setPhone("011233454e3");
		vendor.setCompany(company);


		modelService.save(vendor);
		this.newVendor = vendor;

	}

	@Test
	public void getVendorTest()
	{
		assertNotNull(newVendor);

		final GLUVendorModel vendor = gluVendorDao.getVendor(newVendor.getPk().toString());
		assertNotNull(vendor);

		assertNotNull(vendor.getCompany());

		final List<GLUVendorUserModel> users = gluVendorDao.findUsers(vendor.getCompany().getPk().toString());

		Assert.assertEquals(1, users.size());
	}
}
