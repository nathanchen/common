package info.chenqin.common;

/**
 * User: nathanchen
 * <p/>
 * Date: 20/09/2016
 * <p/>
 * Time: 9:16 PM
 * <p/>
 * Description:
 */
public enum ApiResponseCodeEnum
{
    SUCCESS(0, "成功"),
    REQUEST_PARAM_ERROR(-1, "请求参数有误"),

    CRAWLER_RETURNS_EMPTY(-11, "爬虫没有抓取到数据");



    private int code;
    private String msg;

    ApiResponseCodeEnum(int code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }
}

