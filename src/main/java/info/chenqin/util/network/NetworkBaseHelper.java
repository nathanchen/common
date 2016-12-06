package info.chenqin.util.network;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * User: nathanchen
 * <p/>
 * Date: 27/10/2015
 * <p/>
 * Time: 11:25 PM
 * <p/>
 * Description:
 */
public class NetworkBaseHelper
{
    public static HttpServletRequest getRequest ()
    {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null)
        {
            return null;
        }
        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }
}
