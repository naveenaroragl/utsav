/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package gl.utsav.accelerator.core.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import gl.utsav.accelerator.core.constants.GlutsavacceleratorCoreConstants;
import gl.utsav.accelerator.core.setup.CoreSystemSetup;


/**
 * Do not use, please use {@link CoreSystemSetup} instead.
 * 
 */
@SuppressWarnings("PMD")
public class GlutsavacceleratorCoreManager extends GeneratedGlutsavacceleratorCoreManager
{
	public static final GlutsavacceleratorCoreManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (GlutsavacceleratorCoreManager) em.getExtension(GlutsavacceleratorCoreConstants.EXTENSIONNAME);
	}
}
