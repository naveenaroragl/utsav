/**
 *
 */
package gl.utsav.vendor.services.impl;

import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.jalo.security.JaloSecurityException;
import de.hybris.platform.persistence.security.PasswordEncoder;
import de.hybris.platform.persistence.security.PasswordEncoderFactory;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.user.UserService;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gl.utsav.vendor.dao.VendorDao;
import gl.utsav.vendor.dto.VendorCompanyData;
import gl.utsav.vendor.dto.VendorData;
import gl.utsav.vendor.dto.VendorUserData;
import gl.utsav.vendor.model.GLUVendorCompanyModel;
import gl.utsav.vendor.model.GLUVendorModel;
import gl.utsav.vendor.model.GLUVendorUserModel;
import gl.utsav.vendor.services.VendorRegistrationService;



/**
 *
 */
@Component(value = "gluVendorRegistrationService")
public class VendorRegistrationServiceImpl implements VendorRegistrationService
{

	@Autowired
	private FlexibleSearchService flexibleSearchService;

	@Autowired
	private ModelService modelService;

	@Autowired
	private VendorDao gluVendorDao;

	@Autowired
	private CommonI18NService commonI18NService;

	@Autowired
	private UserService userService;


	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * gl.utsav.vendor.services.GLUVendorRegistrationService#createVendorCompany(gl.utsav.vendor.dto.GLUVendorCompanyData
	 * )
	 */
	@Override
	public GLUVendorCompanyModel createVendorCompany(final VendorCompanyData data)
	{
		//TODO validate input
		final SecureRandom random = new SecureRandom();
		final GLUVendorCompanyModel company = modelService.create(GLUVendorCompanyModel.class);
		final String vendorId = "VendorGroup" + new BigInteger(130, random).toString(32);
		company.setUid(vendorId);
		company.setName(data.getCompanyName());
		company.setDescription(data.getDescription());

		if (data.getAddress() != null)
		{
			final AddressData addressData = data.getAddress();
			final AddressModel addr = modelService.create(AddressModel.class);
			addr.setFirstname(addressData.getFirstName());
			addr.setLastname(addressData.getFirstName());
			addr.setLine1(addressData.getLine1());
			addr.setLine2(addressData.getLine2());
			addr.setTown(addressData.getTown());
			addr.setPostalcode(addressData.getPostalCode());
			addr.setContactAddress(Boolean.TRUE);
			addr.setBillingAddress(Boolean.TRUE);
			addr.setPhone1(addressData.getPhone());
			addr.setOwner(company);
			company.setBillingAddress(addr);
		}
		modelService.save(company);
		return company;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * gl.utsav.vendor.services.GLUVendorRegistrationService#registerVendor(gl.utsav.vendor.model.GLUVendorCompanyModel,
	 * gl.utsav.vendor.dto.GLUVendorData)
	 */
	@Override
	public GLUVendorModel registerVendor(final GLUVendorCompanyModel company, final VendorData data)
	{
		//TODO Validate Input

		final GLUVendorModel vendor = modelService.create(GLUVendorModel.class);
		vendor.setCode("default");
		vendor.setUridomain(data.getUridomain());
		vendor.setVendorType(data.getType());
		vendor.setEmail(data.getEmail());
		vendor.setPhone(data.getPhone());
		vendor.setCompany(company);

		modelService.save(vendor);

		return vendor;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * gl.utsav.vendor.services.GLUVendorRegistrationService#registerVendorUser(gl.utsav.vendor.dto.GLUVendorUserData)
	 */
	@Override
	public GLUVendorUserModel registerVendorUser(final GLUVendorModel vendor, final VendorUserData data)
	{
		//TODO Validate input
		final GLUVendorUserModel um = modelService.create(GLUVendorUserModel.class);
		um.setName(data.getFirstName() + " " + data.getLastName());
		um.setUid(data.getEmail());
		um.setSessionLanguage(commonI18NService.getCurrentLanguage());
		um.setSessionCurrency(commonI18NService.getCurrentCurrency());
		final PasswordEncoderFactory passwordEncoderFactory = Registry.getApplicationContext()
				.getBean("core.passwordEncoderFactory", PasswordEncoderFactory.class);
		final PasswordEncoder deprecatedEncoder = passwordEncoderFactory.getEncoder("md5");
		if (vendor.getCompany() != null)
		{
			final Set set = new HashSet();
			set.add(vendor.getCompany());
			set.add(userService.getUserGroupForUID("vendorGroup"));
			um.setGroups(set);
			um.setCompany(vendor.getCompany());
		}
		um.setPasswordEncoding("md5");
		modelService.save(um);
		userService.setPassword(data.getEmail(), deprecatedEncoder.encode(data.getEmail(), data.getPassword()));
		return um;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * gl.utsav.vendor.services.GLUVendorRegistrationService#setVendorCompanyContact(gl.utsav.vendor.model.GLUVendorModel
	 * , gl.utsav.vendor.model.GLUVendorUserModel)
	 */
	@Override
	public void setVendorCompanyContact(final GLUVendorCompanyModel company, final GLUVendorUserModel contact)
	{
		company.setContact(contact);
		modelService.save(company);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see gl.utsav.vendor.services.VendorRegistrationService#validateAndCreateSession(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean validateAndCreateSession(final String userName, final String password, final HttpServletRequest request)
			throws JaloSecurityException
	{
		final PasswordEncoderFactory passwordEncoderFactory = Registry.getApplicationContext()
				.getBean("core.passwordEncoderFactory", PasswordEncoderFactory.class);
		UserModel userModel = null;
		try
		{
			userModel = userService.getUserForUID(userName);
			if (!userModel.getAllGroups().contains(userService.getUserGroupForUID("vendorGroup")))
			{
				return false;
			}
		}
		catch (final Exception e)
		{
			return false;
		}
		final PasswordEncoder deprecatedEncoder = passwordEncoderFactory.getEncoder(userModel.getPasswordEncoding());
		final String p2 = deprecatedEncoder.encode(userName, password);
		System.out.println("----------------------" + userModel.getEncodedPassword());
		System.out.println("----------------------" + p2);
		if (p2.equals(userModel.getEncodedPassword()))
		{
			/*
			 * request.getSession(true); final JaloSession jSession = JaloConnection.getInstance().createSession(userName,
			 * p2); jSession.activate();
			 */
			final HttpSession session = request.getSession(true);
			session.setAttribute("user", userModel);
			System.out.println("Session ID: " + session.getId());
			System.out.println("User: " + ((UserModel) session.getAttribute("user")).getUid());
			return true;
		}
		return false;
	}
}
