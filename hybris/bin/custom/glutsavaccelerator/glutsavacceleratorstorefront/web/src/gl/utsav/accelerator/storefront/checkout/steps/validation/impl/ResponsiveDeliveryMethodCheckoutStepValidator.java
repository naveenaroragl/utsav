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
package gl.utsav.accelerator.storefront.checkout.steps.validation.impl;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gl.utsav.accelerator.storefront.checkout.steps.validation.AbstractCheckoutStepValidator;
import gl.utsav.accelerator.storefront.checkout.steps.validation.ValidationResults;
import gl.utsav.accelerator.storefront.commonabstract.controllers.util.GlobalMessages;


public class ResponsiveDeliveryMethodCheckoutStepValidator extends AbstractCheckoutStepValidator
{
	@Override
	public ValidationResults validateOnEnter(final RedirectAttributes redirectAttributes)
	{
		if (!getCheckoutFlowFacade().hasValidCart())
		{
			LOG.info("Missing, empty or unsupported cart");
			return ValidationResults.REDIRECT_TO_CART;
		}

		if (getCheckoutFacade().hasShippingItems() && getCheckoutFlowFacade().hasNoDeliveryAddress())
		{
			GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
					"checkout.multi.deliveryAddress.notprovided");
			return ValidationResults.REDIRECT_TO_DELIVERY_ADDRESS;
		}

		if (!getCheckoutFacade().hasShippingItems() && getCheckoutFlowFacade().hasPickUpItems())
		{
			return ValidationResults.REDIRECT_TO_PAYMENT_METHOD;
		}

		return ValidationResults.SUCCESS;
	}

}