package info.chenqin.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * User: nathanchen
 * <p/>
 * Date: 21/09/2016
 * <p/>
 * Time: 2:04 AM
 * <p/>
 * Description:
 */
public final class JsonHelper
{
    public static Object getObject(JSONObject obj, String key, String defaultObj)
    {
        if (obj.containsKey(key))
        {
            return obj.get(key);
        }
        return defaultObj;
    }

    public static String getString(JSONObject obj, String key, String defaultVal)
    {
        if (obj.containsKey(key))
        {
            return obj.getString(key);
        }
        return defaultVal;
    }

    public static int getInt(JSONObject obj, String key, int defaultVal)
    {
        if (obj.containsKey(key))
        {
            try
            {
                return obj.getInt(key);
            }
            catch (Exception ignored)
            {
            }
        }
        return defaultVal;

    }

    public static double getDouble(JSONObject obj, String key, double defaultVal)
    {
        if (obj.containsKey(key))
        {
            try
            {
                return obj.getDouble(key);
            }
            catch (Exception ignored)
            {
            }
        }
        return defaultVal;
    }

    public static BigDecimal getBigDecimal(JSONObject obj, String key, String defaultVal)
    {
        if (obj.containsKey(key))
        {
            try
            {
                return new BigDecimal(obj.getString(key));
            }
            catch (Exception ignored)
            {
            }
        }
        return BigDecimal.ZERO;
    }

    /**
     * 将字符串转化成java对象
     *
     * @param className
     * @param jsonString
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T chgJson2Bean(Class<?> className, Object jsonString)
    {
        Object obj = null;
        if (null != jsonString)
        {
            try
            {
                JSONObject object = JSONObject.fromObject(jsonString);
                obj = JSONObject.toBean(object, className);
            }
            catch (Exception e)
            {
            }
        }
        return (T) obj;
    }

    /**
     * 将字符串转化成复杂的java对象，java包含list等字段
     *
     * @param config
     * @param jsonString
     */
    @SuppressWarnings("unchecked")
    public static <T> T chgJson2Bean(JsonConfig config, String jsonString)
    {
        Object obj = null;
        if (null != jsonString && !"".equals(jsonString.trim()))
        {
            try
            {
                JSONObject jsObject = JSONObject.fromObject(jsonString);
                obj = JSONObject.toBean(jsObject, config);
            }
            catch (Exception ignored)
            {

            }
        }
        return (T) obj;
    }

    /**
     * 将对象转换成json格式字符串
     *
     * @param obj
     * @return
     */
    public static String chgBean2Json(Object obj)
    {
        if (null != obj)
        {
            JSONObject json = JSONObject.fromObject(obj);
            return json.toString();
        }
        return null;
    }

    /**
     * 将列表转换成json格式字符串
     *
     * @param list
     * @return
     */
    public static <T> String chgList2Json(ArrayList<T> list)
    {
        if (null != list)
        {
            JSONArray json = JSONArray.fromObject(list);
            return json.toString();
        }
        return null;
    }
}
