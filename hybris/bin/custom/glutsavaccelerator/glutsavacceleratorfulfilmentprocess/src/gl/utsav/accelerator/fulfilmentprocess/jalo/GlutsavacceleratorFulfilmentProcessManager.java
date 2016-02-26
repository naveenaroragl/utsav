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
package gl.utsav.accelerator.fulfilmentprocess.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import gl.utsav.accelerator.fulfilmentprocess.constants.GlutsavacceleratorFulfilmentProcessConstants;

import org.apache.log4j.Logger;

@SuppressWarnings("PMD")
public class GlutsavacceleratorFulfilmentProcessManager extends GeneratedGlutsavacceleratorFulfilmentProcessManager
{
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger( GlutsavacceleratorFulfilmentProcessManager.class.getName() );
	
	public static final GlutsavacceleratorFulfilmentProcessManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (GlutsavacceleratorFulfilmentProcessManager) em.getExtension(GlutsavacceleratorFulfilmentProcessConstants.EXTENSIONNAME);
	}
	
}
