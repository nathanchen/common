package info.chenqin.util;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * User: nathanchen
 * <p/>
 * Date: 21/09/2016
 * <p/>
 * Time: 12:18 AM
 * <p/>
 * Description:
 */
public class SortingHelper
{
    public static ArrayList<Method> sortMethodsByName (ArrayList<Method> methodArrayList)
    {
        boolean swapped = true;
        int j = 0;
        Method method1, method2;
        while (swapped)
        {
            swapped = false;
            j ++;
            for (int i = 0; i < methodArrayList.size() - j; i ++)
            {
                method1 = methodArrayList.get(i);
                method2 = methodArrayList.get(i + 1);
                if (method1.getName().compareTo(method2.getName()) > 0)
                {
                    methodArrayList.set(i, method2);
                    methodArrayList.set(i + 1, method1);
                    swapped = true;
                }
            }
        }
        return methodArrayList;
    }
}
