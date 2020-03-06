package com.vulcan.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *      确保用户输入的身份证号是正确的
 *      测试时用于生成随机身份证号
 * </p>
 *
 * @author allwayz
 * @since 2020-03-06
 */
public class IdNumberFormatCheckUtil {

    /**
     *
     * @param input
     */
    public static boolean CheckCheck(String input){
        String Result = null;
        double r;
        try
        {
            char[] charArray = input.toCharArray();
            int[] ID_Array = new int[charArray.length];
            for (int i = 0; i < charArray.length; i++)
            {
                ID_Array[i] = charArray[i] - '0';
            }
            double Sum = 0;
            int count = 0;
            for (int i = 0; i < ID_Array.length - 1; i++)
            {
                double Wi = Math.pow(2, 18 - (i + 1)) % 11;
                Sum += Wi * ID_Array[i];
                count++;
            }
            r = (12 - Sum % 11) % 11;
            //System.out.println(r);
            if (r == ID_Array[17])
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
