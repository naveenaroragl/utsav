package gl.utsav.accelerator.core.packages.dao.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gl.utsav.accelerator.core.enums.EventTypeEnum;
import gl.utsav.accelerator.core.model.PackageModel;
import gl.utsav.accelerator.core.packages.dao.PackageDao;


@Component(value = "packageDAO")
public class DefaultPackageDao implements PackageDao
{
	@Autowired
	private FlexibleSearchService flexibleSearchService;

	@Override
	public List<PackageModel> findAllPackages()
	{
		final String queryString = "SELECT {p:" + PackageModel.PK + "} " + "FROM {" + PackageModel._TYPECODE + " AS p} ";
		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

		return flexibleSearchService.<PackageModel> search(query).getResult();
	}

	@Override
	public List<PackageModel> findPackagesByType(final EventTypeEnum eventType)
	{
		final String queryString = "SELECT {p:" + PackageModel.PK + "} " + "FROM {" + PackageModel._TYPECODE + " AS p} " + "WHERE "
				+ "{p:" + PackageModel.EVENTTYPE + "}=?eventType ";
		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		query.addQueryParameter("eventType", eventType);

		return flexibleSearchService.<PackageModel> search(query).getResult();
	}

	@Override
	public List<PackageModel> findPackageByCode(final String code)
	{
		final String queryString = "SELECT {p:" + PackageModel.PK + "} " + "FROM {" + PackageModel._TYPECODE + " AS p} " + "WHERE "
				+ "{p:" + PackageModel.CODE + "}=?code ";
		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

		return flexibleSearchService.<PackageModel> search(query).getResult();
	}
}
