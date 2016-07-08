/**
 *
 */
package gl.utsav.vendor.validator;

/**
 * @author Deepak.J
 *
 */
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import gl.utsav.vendor.dto.VendorRegistrationData;


@Component
public class VendorValidator implements Validator
{

	public boolean supports(final Class clazz)
	{
		return VendorRegistrationData.class.isAssignableFrom(clazz);
	}

	public void validate(final Object target, final Errors errors)
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userData.email", "error.firstName", "Username is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userData.password", "error.lastName", "Password is required.");
	}

}