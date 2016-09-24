package info.chenqin.util;

import com.google.common.base.Strings;
import info.chenqin.apirequest.BaseAPIRequestModel;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * User: nathanchen
 * <p/>
 * Date: 21/09/2016
 * <p/>
 * Time: 12:09 AM
 * <p/>
 * Description:
 */
@Slf4j
public final class MethodHelper
{
    public static void generateSign(BaseAPIRequestModel baseAPIRequestModel)
    {
        Class<?> baseAPIRequestClass = baseAPIRequestModel.getClass();
        Method[] methods = baseAPIRequestClass.getMethods();
        ArrayList<Method> methodArrayList = new ArrayList<>(methods.length - 1);
        String methodName;

        for (Method method : methods)
        {
            methodName = method.getName();

            if (methodName.equals("getSign"))
            {
                continue;
            }
            else if (ClassHelper.isGetterMethod(method))
            {
                // 筛选sign加密的备选getter方法名
                methodArrayList.add(method);
            }
        }
        SortingHelper.sortMethodsByName(methodArrayList);
        StringBuilder stringBuilder = new StringBuilder();
        String value;
        for (Method method : methodArrayList)
        {
            try
            {
                // 生成sign的明文
                value = Strings.nullToEmpty(String.valueOf(method.invoke(baseAPIRequestModel))).trim();
                stringBuilder.append(value);
            }
            catch (IllegalAccessException | InvocationTargetException e)
            {
                e.printStackTrace();
            }
        }
        String candidateString = stringBuilder.toString();
        String encryptedString = EncryptionHelper.getSaltedMD5(PropertiesFileHelper.getGlobalAPIToken(), candidateString);
        baseAPIRequestModel.setSign(encryptedString);

        log.debug("MD5 before ======> " + candidateString + "\rMD5 after ======> " + encryptedString);
    }
}
