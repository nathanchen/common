package info.chenqin.util;

/**
 * User: nathanchen
 * <p/>
 * Date: 21/09/2016
 * <p/>
 * Time: 2:01 AM
 * <p/>
 * Description:
 */
public class LogHelper
{
    public static String replaceRedisValueLoggerFormat (String redisKey)
    {
        return "Replace redis value: key - " + redisKey;
    }

    public static String wapRedisOperateServiceCostTimeLoggerFormat (String title, long time)
    {
        return String.format("Wap Redis Operate Service %s finishes in %s ms", title, time);
    }

    public static String wapRedisOperateServiceStartedLoggerFormat (String title)
    {
        return String.format("Wap Redis Operate Service %s started", title);
    }

    public static String redisDeleteLoggerFormat (String redisKey, String infoMD5)
    {
        return String.format("Redis Delete: %s - %s", redisKey, infoMD5);
    }

    public static String redisInsertLoggerFormat (String redisKey, String infoMD5)
    {
        return String.format("Redis Insert: %s - %s", redisKey, infoMD5);
    }

    public static String redisCheckPassLoggerFormat (String redisKey, String infoMD5)
    {
        return String.format("Redis Check Pass: %s - %s", redisKey, infoMD5);
    }

    public static String baseRequestProfileLoggerFormat(String requestURL)
    {
        return "Request URL: " + requestURL;
    }

    public static String apiRequestResponseLoggerFormat(String url, String baseAPIRequestString, String responseContent)
    {
        return String.format("APIRequest: %s%nRequest: %s%nResponse: %s", url, baseAPIRequestString, responseContent);
    }

    public static String apiRequestDecryptedResponse(String responseContent)
    {
        return "DecryptResponse: " + responseContent;
    }

    public static String userInputFormat(String message, Object object)
    {
        return String.format("INPUT ERROR: %s - %s", message, object.toString());
    }

    public static String userInputFormat(String custId, String message, Object object)
    {
        return String.format("USER: %s INPUT ERROR: %s - %s", custId, message, object.toString());
    }
}
