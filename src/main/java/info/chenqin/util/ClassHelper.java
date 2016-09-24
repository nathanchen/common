package info.chenqin.util;

import java.lang.reflect.Method;

/**
 * User: nathanchen
 * <p/>
 * Date: 21/09/2016
 * <p/>
 * Time: 12:15 AM
 * <p/>
 * Description:
 */
public final class ClassHelper
{
    public static boolean isGetterMethod (Method method)
    {
        if (!method.getName().startsWith("get"))
        {
            return false;
        }
        if (method.getParameterTypes().length != 0)
        {
            return false;
        }
        if (void.class.equals(method.getReturnType()))
        {
            return false;
        }
        return true;
    }

    public static boolean isSetterMethod (Method method)
    {
        if (!method.getName().startsWith("set"))
        {
            return false;
        }
        if (method.getParameterTypes().length == 0)
        {
            return false;
        }
        if (!void.class.equals(method.getReturnType()))
        {
            return false;
        }
        return true;
    }

}
