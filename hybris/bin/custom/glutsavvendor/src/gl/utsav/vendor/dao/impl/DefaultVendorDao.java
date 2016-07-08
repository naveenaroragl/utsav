/**
 *
 */
package gl.utsav.vendor.dao.impl;

import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gl.utsav.vendor.dao.VendorDao;
import gl.utsav.vendor.model.GLUVendorModel;
import gl.utsav.vendor.model.GLUVendorUserModel;


/**
 *
 */
@Component(value = "gluVendorDao")
public class DefaultVendorDao implements VendorDao
{

	@Autowired
	private FlexibleSearchService flexibleSearchService;

	@Autowired
	private ModelService modelService;

	/*
	 * (non-Javadoc)
	 *
	 * @see gl.utsav.vendor.dao.GLUVendorDao#getVendor(java.lang.String)
	 */
	@Override
	public GLUVendorModel getVendor(final String vendorId)
	{

		final String queryString = "SELECT {p:" + GLUVendorModel.PK + "} " + "FROM {" + GLUVendorModel._TYPECODE + " AS p} "
				+ "WHERE " + "{p:" + GLUVendorModel.PK + "}=?pk ";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		query.addQueryParameter("pk", vendorId);

		final List<GLUVendorModel> items = flexibleSearchService.<GLUVendorModel> search(query).getResult();

		return items.size() > 0 ? items.get(0) : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gl.utsav.vendor.dao.GLUVendorDao#findUsers(java.lang.String)
	 */
	@Override
	public List<GLUVendorUserModel> findUsers(final String companayId)
	{

		final String queryString = "SELECT {p:" + GLUVendorUserModel.PK + "} " + "FROM {" + GLUVendorUserModel._TYPECODE
				+ " AS p} " + "WHERE " + "{p:" + GLUVendorUserModel.COMPANY + "}=?companayId ";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		query.addQueryParameter("companayId", companayId);

		return flexibleSearchService.<GLUVendorUserModel> search(query).getResult();
	}





}
