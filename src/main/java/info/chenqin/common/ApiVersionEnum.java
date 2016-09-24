package info.chenqin.common;

/**
 * User: nathanchen
 * <p/>
 * Date: 19/09/2016
 * <p/>
 * Time: 1:27 PM
 * <p/>
 * Description:
 */
public enum ApiVersionEnum
{
    V1("v1");

    String code;

    ApiVersionEnum(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public static boolean isValidApiVersion(String apiVersion)
    {
        for (ApiVersionEnum apiVersionEnum : values())
        {
            if (apiVersion.equals(apiVersionEnum.getCode()))
            {
                return true;
            }
        }
        return false;
    }
}
