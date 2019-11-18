package com.yh.shenji.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * class 工具类
 *
 * @author YangDongYu
 * @date 2019/11/15 13:45
 */
@Slf4j
public class ClassUtils {
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error("CLASS NOT FOUND", e);
            throw new RuntimeException(e);
        }
    }

    public static Set<Class<?>> loadClassSet(boolean recursive, String... packageName) {

        return null;
    }
}
