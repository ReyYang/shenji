package com.yh.shenji.utils;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Demo StringUtils
 *
 * @author YangDongYu
 * @date 2019/11/18 20:04
 */
public class StringUtils {
    public static String reference2Path(String name) {
        return name.replaceAll("\\.", "/");
    }

    public static List<String> reference2Path(Collection<String> names) {
        List<String> resultList = new ArrayList<>();
        for (String name : names) {
            resultList.add(reference2Path(name));
        }
        return resultList;
    }
}
