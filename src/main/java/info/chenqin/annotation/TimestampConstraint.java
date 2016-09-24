package info.chenqin.annotation;

import info.chenqin.annotation.validator.TimestampConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * User: nathanchen
 * <p/>
 * Date: 19/09/2016
 * <p/>
 * Time: 2:51 PM
 * <p/>
 * Description:
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TimestampConstraintValidator.class)
public @interface TimestampConstraint
{
    String message() default "{TimestampConstraint}";

    /**
     * @return 是否允许空值
     */
    boolean empty() default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
