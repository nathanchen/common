package info.chenqin.util.network;

import com.google.common.base.Strings;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * User: nathanchen
 * <p>
 * Date: 6/12/16
 * <p>
 * Time: 10:44 AM
 * <p>
 * Description:
 */
public class WebCookiesUtil
{
    private static final String LOCAL_STORAGE_VERSION_COOKIES_NAME = "lsv";

    public static void setLocalStorageVersion(String version, HttpServletResponse httpServletResponse)
    {
        newCookie(LOCAL_STORAGE_VERSION_COOKIES_NAME, 24 * 365, version, httpServletResponse);
    }

    public static String getLocalStorageVersion()
    {
        return getCookieValue(LOCAL_STORAGE_VERSION_COOKIES_NAME);
    }

    private static String getCookieValue(String cookies_name, String defaultValue)
    {
        return !Strings.isNullOrEmpty(getCookieValue(cookies_name)) ? defaultValue : getCookieValue(cookies_name);
    }

    private static String getCookieValue(String cookies_name)
    {
        HttpServletRequest request = NetworkBaseHelper.getRequest();
        if (request != null)
        {
            Cookie[] cookies = request.getCookies();
            if (cookies != null)
            {
                for (Cookie cookie : cookies)
                {
                    if (cookie.getName().equalsIgnoreCase(cookies_name))
                    {
                        try
                        {
                            return URLDecoder.decode(cookie.getValue(), "UTF-8");
                        }
                        catch (UnsupportedEncodingException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "";
    }

    public static Cookie newCookie(String cookies_name, int hours, String value, HttpServletResponse response)
    {
        Cookie cookie = null;

        if (hours == 0)
        {
            value = "deleted";
        }

        if (!Strings.isNullOrEmpty(value))
        {
            try
            {
                cookie = new Cookie(cookies_name, URLEncoder.encode(value, "UTF-8"));
                cookie.setPath("/");
                cookie.setMaxAge(hours * 60 * 60);
                response.addCookie(cookie);
            }
            catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }
        }
        return cookie;
    }
}
