package com.yh.shenji.utils;

import com.yh.shenji.exception.WoodException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Demo PropertyUtils
 *
 * @author YangDongYu
 * @date 2019/11/25 17:06
 */
public class PropertyUtils {

    private static final Logger logger = LoggerFactory.getLogger(PropertyUtils.class);

    /**
     * 功能描述: 读取配置文件信息
     * @param prop 配置文件路径
     * @return : java.util.Properties
     * @author : yangyihui
     * @date : 2019/11/25 19:11
     */
    public static Properties loadProperties(String prop) {
        Properties properties = null;
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(prop)) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            logger.error(prop + "file isn't found");
            throw new WoodException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new WoodException(e);
        }
        return properties;
    }

    /**
     * 功能描述: 获取配置文件字符型属性值
     * @param properties 配置文件映射类
     * @param key 键值
     * @param defaultValue 默认值
     * @return : java.lang.String
     * @author : yangyihui
     * @date : 2019/11/25 17:57
     */
    public static String getString(Properties properties, String key, String defaultValue) {
        String value = defaultValue;
        if (properties.containsKey(key)) {
            value = properties.getProperty(key);
        }
        return value;
    }

    /**
     * 功能描述: 获取配置文件字符型属性值(默认值为空)
     * @param properties 配置文件映射类
     * @param key 键值
     * @return : java.lang.String
     * @author : yangyihui
     * @date : 2019/11/25 18:03
     */
    public static String getString(Properties properties, String key) {
        return getString(properties, key, "");
    }

    /**
     * 功能描述:获取配置文件整型属性值(默认值为0)
     * @param properties 配置文件映射类
     * @param key 键值
     * @return : java.lang.Integer
     * @author : yangyihui
     * @date : 2019/11/25 19:11
     */
    public static Integer getInteger(Properties properties, String key) {
        return getInteger(properties, key, 0);
    }

    /**
     * 功能描述: 获取配置文件整型属性值
     * @param properties 配置文件映射类
     * @param key 键值
     * @param defaultValue 默认值
     * @return : java.lang.Integer
     * @author : yangyihui
     * @date : 2019/11/25 19:10
     */
    public static Integer getInteger(Properties properties, String key, int defaultValue) {
        int value = defaultValue;
        if (properties.containsKey(key)) {
            value = CastUtils.castInt(properties.getProperty(key));
        }
        return value;
    }
}
