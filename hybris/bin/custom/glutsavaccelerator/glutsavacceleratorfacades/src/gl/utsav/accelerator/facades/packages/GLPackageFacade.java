
package gl.utsav.accelerator.facades.packages;

import gl.utsav.accelerator.core.model.PackageModel;
import gl.utsav.accelerator.facades.packages.data.PackageData;


/**
 * Facade to provide Category Data for a Category Model.
 */
public interface GLPackageFacade
{
	PackageData getPackageData(PackageModel packageModel);

}
