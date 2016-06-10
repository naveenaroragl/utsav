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
package gl.utsav.accelerator.storefront.forms.payment.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import gl.utsav.accelerator.storefront.forms.payment.MerchantCallbackUrlStrategy;


@Component("merchantCallbackUrlStrategy")
public class DefaultMerchantCallbackUrlStrategy implements MerchantCallbackUrlStrategy
{
	@Resource
	private ConfigurationService configurationService;

	@Override
	public String getUrl()
	{
		return configurationService.getConfiguration().getString("merchant.callback.url", "");
	}
}
