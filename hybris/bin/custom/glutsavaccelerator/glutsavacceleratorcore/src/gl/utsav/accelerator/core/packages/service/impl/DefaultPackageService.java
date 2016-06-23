package gl.utsav.accelerator.core.packages.service.impl;

import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import gl.utsav.accelerator.core.enums.EventTypeEnum;
import gl.utsav.accelerator.core.model.PackageModel;
import gl.utsav.accelerator.core.packages.dao.PackageDao;
import gl.utsav.accelerator.core.packages.service.PackageService;


public class DefaultPackageService implements PackageService
{
	private PackageDao packageDAO;

	@Override
	public List<PackageModel> getAllPackages()
	{
		return packageDAO.findAllPackages();
	}


	@Override
	public PackageModel getPackageByType(final EventTypeEnum eventType)
			throws AmbiguousIdentifierException, UnknownIdentifierException
	{
		final List<PackageModel> result = packageDAO.findPackagesByType(eventType);
		if (result.isEmpty())
		{
			throw new UnknownIdentifierException("Package with type '" + eventType + "' not found!");
		}
		else if (result.size() > 1)
		{
			throw new AmbiguousIdentifierException(
					"Package type '" + eventType + "' is not unique, " + result.size() + " packages found!");
		}
		return result.get(0);
	}


	@Override
	public PackageModel getPackageByCode(final String code) throws AmbiguousIdentifierException, UnknownIdentifierException
	{
		final List<PackageModel> result = packageDAO.findPackageByCode(code);
		if (result.isEmpty())
		{
			throw new UnknownIdentifierException("Package with code '" + code + "' not found!");
		}
		else if (result.size() > 1)
		{
			throw new AmbiguousIdentifierException(
					"Package code '" + code + "' is not unique, " + result.size() + " packages found!");
		}
		return result.get(0);
	}

	@Required
	public void setPackageDao(final PackageDao packageDAO)
	{
		this.packageDAO = packageDAO;
	}
}
