package info.chenqin.annotation.validator;

import com.google.common.base.Strings;
import info.chenqin.annotation.ApiVersionConstraint;
import info.chenqin.common.ApiVersionEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * User: nathanchen
 * <p/>
 * Date: 19/09/2016
 * <p/>
 * Time: 1:22 PM
 * <p/>
 * Description:
 */
public class ApiVersionConstraintValidator implements ConstraintValidator<ApiVersionConstraint, String>
{
    private boolean empty;

    @Override
    public void initialize(ApiVersionConstraint constraintAnnotation)
    {
        empty = constraintAnnotation.empty();
    }

    public boolean isValid (String apiVersion, ConstraintValidatorContext constraintValidatorContext)
    {
        if (Strings.isNullOrEmpty(apiVersion))
        {
            return empty;
        }
        return ApiVersionEnum.isValidApiVersion(apiVersion);
    }
}
