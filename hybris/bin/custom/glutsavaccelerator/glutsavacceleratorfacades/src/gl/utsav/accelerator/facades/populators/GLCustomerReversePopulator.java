/**
 *
 */
package gl.utsav.accelerator.facades.populators;

import de.hybris.platform.commercefacades.user.converters.populator.CustomerReversePopulator;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.apache.commons.lang.StringUtils;


/**
 * @author nidhi.singh1
 *
 */
public class GLCustomerReversePopulator extends CustomerReversePopulator
{

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.converters.Populator#populate(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void populate(final CustomerData source, final CustomerModel target) throws ConversionException
	{
		super.populate(source, target);
		if (StringUtils.isNotBlank(source.getPhone()))
		{
			target.setPhone(source.getPhone());
		}
	}

}
