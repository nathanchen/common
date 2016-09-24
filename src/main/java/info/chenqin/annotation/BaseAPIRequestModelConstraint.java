package info.chenqin.annotation;

import info.chenqin.annotation.validator.BaseAPIRequestModelConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * User: nathanchen
 * <p/>
 * Date: 20/09/2016
 * <p/>
 * Time: 5:22 PM
 * <p/>
 * Description:
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BaseAPIRequestModelConstraintValidator.class)
public @interface BaseAPIRequestModelConstraint
{
    String message() default "{ApiVersionConstraint}";

    /**
     * @return 是否允许空值
     */
    boolean empty() default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
