package com.yh.shenji.helper;

import com.yh.shenji.constant.ConfigConstant;
import com.yh.shenji.utils.PropertyUtils;

import java.util.Properties;

/**
 * Demo ConfigHelper
 *
 * @author YangDongYu
 * @date 2019/11/25 17:05
 */
public class ConfigHelper {
    private static final Properties configProperties = PropertyUtils.loadProperties(ConfigConstant.BASE_CONFIG_FILE_PROP);
}
