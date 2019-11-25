package com.yh.shenji.utils;

import com.google.common.collect.Lists;
import com.yh.shenji.exception.WoodException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * class 工具类
 *
 * @author YangDongYu
 * @date 2019/11/15 13:45
 */
public class ClassUtils {
    private static final Logger logger = LoggerFactory.getLogger(ClassUtils.class);

    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Set<Class<?>> loadClassSet(String... packageName) {
        List<String> packagePath = StringUtils.reference2Path(Lists.newArrayList(packageName));
        try {
            for (String path : packagePath) {
                Set<Class<?>> classSet = new HashSet<>();
                Enumeration<URL> resources = getClassLoader().getResources(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new WoodException(e);
        }
        return null;
    }

    public static Set<Class<?>> loadClassSet(String packageName) {
        String packagePath = StringUtils.reference2Path(packageName);
        Set<Class<?>> resultSet = new HashSet<>();
        try {
            Enumeration<URL> resources = getClassLoader().getResources(packagePath);
            while (resources.hasMoreElements()) {
                URL currentURL = resources.nextElement();
                if ("file".equals(currentURL.getProtocol())) {
                    String path = currentURL.getPath().replaceAll("%20", " ");
                    addClass(path, packageName, resultSet);
                } else if ("jar".equals(currentURL.getProtocol())) {
                    JarURLConnection jarURLConnection = (JarURLConnection) currentURL.openConnection();
                    JarFile jarFile = jarURLConnection.getJarFile();
                    Enumeration<JarEntry> entries = jarFile.entries();
                    while (entries.hasMoreElements()) {
                        JarEntry jarEntry = entries.nextElement();
                        String jarEntryName = jarEntry.getName();
                        if (jarEntryName.endsWith(".class")) {
                            String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replaceAll("/", ".");
                            resultSet.add(loadClass(className));
                        }
                    }
                } else {
                    throw new WoodException("路径查询失败");
                }
            }
            return resultSet;
        } catch (IOException e) {
            e.printStackTrace();
            throw new WoodException(e);
        }
    }

    private static void addClass(String path, String packageName, Set<Class<?>> resultSet) {
        File[] files =
                new File(path).listFiles(file -> (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory());
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String subFileName = file.getName();
                    String className = subFileName.substring(0, subFileName.lastIndexOf("."));
                    resultSet.add(loadClass(packageName + "." + className));
                } else if (file.isDirectory()) {
                    addClass(file.getAbsolutePath(), packageName + "." + file.getName(), resultSet);
                }
            }
        }
    }
}
