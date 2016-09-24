package info.chenqin.apiresponse;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User: nathanchen
 * <p/>
 * Date: 20/09/2016
 * <p/>
 * Time: 9:14 PM
 * <p/>
 * Description:
 */
@NoArgsConstructor
@Data
public abstract class BaseAPIResponse
{
    private int code = -999;
    private String message = "";

    public BaseAPIResponse(int code)
    {
        this.code = code;
    }

    public BaseAPIResponse(int code, String message)
    {
        this.code = code;
        this.message = message;
    }
}
