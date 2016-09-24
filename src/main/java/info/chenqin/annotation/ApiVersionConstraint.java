package info.chenqin.annotation;

import info.chenqin.annotation.validator.ApiVersionConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * User: nathanchen
 * <p/>
 * Date: 19/09/2016
 * <p/>
 * Time: 1:20 PM
 * <p/>
 * Description:
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ApiVersionConstraintValidator.class)
public @interface ApiVersionConstraint
{
    String message() default "{ApiVersionConstraint}";

    /**
     * @return 是否允许空值
     */
    boolean empty() default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
