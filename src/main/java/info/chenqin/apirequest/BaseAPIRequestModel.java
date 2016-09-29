package info.chenqin.apirequest;

import info.chenqin.annotation.ApiVersionConstraint;
import info.chenqin.annotation.BaseAPIRequestModelConstraint;
import info.chenqin.annotation.TimestampConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * User: nathanchen
 * <p/>
 * Date: 20/09/2016
 * <p/>
 * Time: 5:31 PM
 * <p/>
 * Description:
 */
@Data
@BaseAPIRequestModelConstraint
public class BaseAPIRequestModel
{
    // 调用Api的版本号
    @ApiVersionConstraint
    private String apiVersion;

    @TimestampConstraint
    private long timestamp;

    // 加密字符串
    @NotNull
    @NotEmpty
    private String sign;
}
