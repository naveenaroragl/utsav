package gl.utsav.accelerator.core.packages.service;

import java.util.List;

import gl.utsav.accelerator.core.enums.EventTypeEnum;
import gl.utsav.accelerator.core.model.PackageModel;


public interface PackageService
{
	/**
	 * Gets all packages of the system.
	 *
	 * @return all packages of system
	 */
	List<PackageModel> getAllPackages();


	/**
	 * Gets the package for given type.
	 */
	PackageModel getPackageByType(EventTypeEnum eventType);


	/**
	 * Gets the package for given code.
	 */
	PackageModel getPackageByCode(String code);
}
