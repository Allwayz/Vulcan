package com.vulcan.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *<p>
 *     用于确定用户输入的邮箱账号是否符合标准
 *</p>
 *
 * @author allwayz
 * @since 2020-03-06
 */
public class MailFormatCheckUtil {
    /**
     *
     * @param content
     * @return
     */
    public static boolean checkEmailFormat(String content){
        /*
         * " \w"：匹配字母、数字、下划线。等价于'[A-Za-z0-9_]'。
         * "|"  : 或的意思，就是二选一
         * "*" : 出现0次或者多次
         * "+" : 出现1次或者多次
         * "{n,m}" : 至少出现n个，最多出现m个
         * "$" : 以前面的字符结束
         */
        String REGEX="^\\w+((-\\w+)|(\\.\\w+))*@\\w+(\\.\\w{2,3}){1,3}$";
        Pattern p = Pattern.compile(REGEX);
        Matcher matcher=p.matcher(content.trim());

        return matcher.matches();
    }
}
