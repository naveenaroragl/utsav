package gl.utsav.accelerator.core.packages.dao;

import de.hybris.platform.servicelayer.internal.dao.Dao;

import java.util.List;

import gl.utsav.accelerator.core.enums.EventTypeEnum;
import gl.utsav.accelerator.core.model.PackageModel;


public interface PackageDao extends Dao
{

	/**
	 * Return a list of package models that are currently persisted. If none are found an empty list is returned.
	 *
	 * @return all Packages of system
	 */
	List<PackageModel> findAllPackages();


	/**
	 * Finds all packages with given type. If none is found, an empty list will be returned.
	 *
	 * @param eventType
	 *           the eventType to search for packages
	 * @return All Packages with the given type.
	 */
	List<PackageModel> findPackagesByType(EventTypeEnum eventType);


	/**
	 * Finds all packages with given code. If none is found, an empty list will be returned.
	 *
	 * @param code
	 *           the code to search for packages
	 * @return All packages with the given code.
	 */
	List<PackageModel> findPackageByCode(String code);
}
