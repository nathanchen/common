package info.chenqin.annotation.validator;

import info.chenqin.annotation.TimestampConstraint;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * User: nathanchen
 * <p/>
 * Date: 19/09/2016
 * <p/>
 * Time: 2:52 PM
 * <p/>
 * Description:
 */
@Slf4j
public class TimestampConstraintValidator implements ConstraintValidator<TimestampConstraint, Long>
{
    private boolean empty;
    private static final int REQUEST_VALID_MILLISECONDS = 5 * 60 * 1000;

    @Override
    public void initialize(TimestampConstraint constraintAnnotation)
    {
        empty = constraintAnnotation.empty();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context)
    {
        if (value == 0)
        {
            return empty;
        }
        else
        {
            long timeDifference = System.currentTimeMillis() - value;
            return timeDifference <= REQUEST_VALID_MILLISECONDS && timeDifference >= 0;
        }
    }
}
