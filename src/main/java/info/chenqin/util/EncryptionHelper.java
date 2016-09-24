package info.chenqin.util;

import com.google.common.base.Strings;

import java.security.MessageDigest;

/**
 * User: nathanchen
 * <p/>
 * Date: 20/09/2016
 * <p/>
 * Time: 5:34 PM
 * <p/>
 * Description:
 */
public class EncryptionHelper
{
    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * MD5加密
     *
     * @param str
     * @return
     *
     * @author LiuYi
     */
    public static String getMD5(String str)
    {
        return getImpMD5String(str);
    }

    public static String getSaltedMD5(String salt, String... candidateStringArray)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : candidateStringArray)
        {
            stringBuilder.append(string);
        }
        return getMD5(stringBuilder.append(salt).toString());
    }

    /**
     * 加密
     *
     * @param args
     *         一串待加密的字符串
     * @return MD5加密后的字符串
     */
    public static String encrypt(String... args)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : args)
        {
            stringBuilder.append(string);
        }
        return getImpMD5String(stringBuilder.toString());
    }

    /**
     * MD5加密
     *
     * @param str
     * @return MD5加密后的字符串
     */
    private static String getImpMD5String(String str)
    {
        try
        {
            byte[] res = str.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] result = md.digest(res);
            for (byte aResult : result)
            {
                md.update(aResult);
            }
            StringBuilder d = new StringBuilder("");
            for (byte aResult : result)
            {
                int v = aResult & 0xFF;
                if (v < 16)
                {
                    d.append("0");
                }
                d.append(Integer.toString(v, 16)).append("");
            }
            return d.toString().trim().toUpperCase();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 比较加密过的字符串和未加密的字符串是否匹配
     *
     * @param encrypted_string
     *         加密过的字符串
     * @param candidate_string
     *         未加密的字符串
     * @return 是否匹配
     */
    public static boolean compare(String encrypted_string, String candidate_string)
    {
        if (!Strings.isNullOrEmpty(encrypted_string) && !Strings.isNullOrEmpty(candidate_string))
        {
            if (encrypted_string.equals(getImpMD5String(candidate_string)))
            {
                return true;
            }
        }
        return false;
    }

    public static String MD5Encode(String origin, String charsetname)
    {
        String resultString = null;
        try
        {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
            {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            }
            else
            {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return resultString;
    }

    private static String byteArrayToHexString(byte b[])
    {
        StringBuilder resultSb = new StringBuilder();
        for (byte aB : b)
        {
            resultSb.append(byteToHexString(aB));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b)
    {
        int n = b;
        if (n < 0)
        {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
}
