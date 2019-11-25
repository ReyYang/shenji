package com.yh.shenji.utils;

import lombok.val;
import org.apache.commons.lang3.StringUtils;

/**
 * Demo CastUtils
 *
 * @author YangDongYu
 * @date 2019/11/25 18:59
 */
public class CastUtils {

    /**
     * 功能描述: 转换成Int （可选默认值）
     * @param object 待转换类型
     * @param defaultValue 默认值
     * @return : int
     * @author : yangyihui
     * @date : 2019/11/25 19:04
     */
    public static int castInt(Object object, int defaultValue) {
        int val = 0;
        if (object != null) {
            String str = castString(object);
            if (StringUtils.isNotEmpty(str)) {
                try {
                    val = Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    val = defaultValue;
                }
            }
        }
        return val;
    }

    /**
     * 功能描述: 转换成Int（默认值为0）
     * @param obj 待转换类型
     * @return : int
     * @author : yangyihui
     * @date : 2019/11/25 19:09
     */
    public static int castInt(Object obj) {
        return castInt(obj, 0);
    }

    /**
     * 功能描述: 转换类型string（默认值为空）
     *
     * @param object 1
     * @return : java.lang.String
     * @author : yangyihui
     * @date : 2019/11/25 19:04
     */
    private static String castString(Object object) {
        return castString(object, "");
    }

    /**
     * 功能描述: 转换类型String（可选默认值）
     * @param object 待转换类型
     * @param defaultValue 默认值
     * @return : java.lang.String
     * @author : yangyihui
     * @date : 2019/11/2506
     */
    public static String castString(Object object, String defaultValue) {
        String val = defaultValue;
        if (object != null) {
            val = String.valueOf(object);
        }
        return val;
    }
}
