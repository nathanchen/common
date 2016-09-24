package info.chenqin.annotation.validator;

import info.chenqin.annotation.BaseAPIRequestModelConstraint;
import info.chenqin.apirequest.BaseAPIRequestModel;
import info.chenqin.util.MethodHelper;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * User: nathanchen
 * <p/>
 * Date: 20/09/2016
 * <p/>
 * Time: 5:23 PM
 * <p/>
 * Description:
 */
public class BaseAPIRequestModelConstraintValidator implements ConstraintValidator<BaseAPIRequestModelConstraint, BaseAPIRequestModel>
{
    @Override
    public void initialize(BaseAPIRequestModelConstraint constraintAnnotation)
    {

    }

    @Override
    public boolean isValid(BaseAPIRequestModel baseAPIRequestModel, ConstraintValidatorContext context)
    {
        String requestSignValue = baseAPIRequestModel.getSign();

        // 根据request传入的参数值，生成一个合法的sign作为比对
        MethodHelper.generateSign(baseAPIRequestModel);
        String validSign = baseAPIRequestModel.getSign();

        return validSign.equals(requestSignValue);
    }
}
