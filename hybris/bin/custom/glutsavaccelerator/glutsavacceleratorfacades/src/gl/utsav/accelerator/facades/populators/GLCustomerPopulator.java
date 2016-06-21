/**
 *
 */
package gl.utsav.accelerator.facades.populators;

import de.hybris.platform.commercefacades.user.converters.populator.CustomerPopulator;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;


/**
 * @author nidhi.singh1
 *
 */
public class GLCustomerPopulator extends CustomerPopulator
{

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.converters.Populator#populate(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void populate(final CustomerModel source, final CustomerData target) throws ConversionException
	{
		super.populate(source, target);
		target.setPhone(source.getPhone());
	}
}
