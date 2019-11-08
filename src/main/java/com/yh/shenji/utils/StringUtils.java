package com.yh.shenji.utils;

/**
 * Demo StringUtils
 *
 * @author YangDongYu
 * @date 2019/11/7 17:45
 */
public class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
