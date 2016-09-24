package info.chenqin.util;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * User: nathanchen
 * <p/>
 * Date: 20/09/2016
 * <p/>
 * Time: 5:41 PM
 * <p/>
 * Description:
 */
public abstract class PropertiesFileHelper
{
    private static Properties globalApiConfigProperties;
    private static final Object LOCKER = new Object();
    private static final String GLOBAL_API_CONFIG_PROPERTIES_FILE_PATH = "conf/global-api-config.properties";

    static {
        globalApiConfigProperties = initProperties(globalApiConfigProperties, GLOBAL_API_CONFIG_PROPERTIES_FILE_PATH);
    }

    public static String getGlobalAPIToken()
    {
        return globalApiConfigProperties.getProperty("api-token");
    }

    protected static Properties initProperties(Properties properties, String properties_file_path)
    {
        if (properties == null)
        {
            synchronized (LOCKER)
            {
                try
                {
                    return PropertiesLoaderUtils.loadAllProperties(properties_file_path, PropertiesFileHelper.class.getClassLoader());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}
