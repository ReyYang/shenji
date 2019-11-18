package com.yh.shenji.proxy;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * Demo BaseAOP
 *
 * @author YangDongYu
 * @date 2019/11/13 11:49
 */
@Slf4j
public class BaseAOP {
    static {
        log.warn("====================== BASE AOP =========================");
        Map<Class<?>, List<BaseProxy>> proxyMap;
        try {
            proxyMap = getProxyMap();
            for (Map.Entry<Class<?>, List<BaseProxy>> entry : proxyMap.entrySet()) {
                Class<?> sourceClass = entry.getKey();
                List<BaseProxy> proxyList = entry.getValue();
                Object proxyInstance = AspectProxyManager.getProxyInstance(sourceClass, proxyList);
                // 使用“代理对象” 替换 “被代理对象”
                BaseAOP.putBean(sourceClass, proxyInstance);
            }
        } catch (Exception e) {
            log.error("BASE AOP", e);
            throw new RuntimeException(e);
        }
    }

    private static void putBean(Class<?> sourceClass, Object proxyInstance) {


    }

    /**
     * 功能描述:生成 (被代理类,代理类集（或称为代理链）) 映射
     * @return : java.util.Map<ja/va.lang.Class<?>,java.util.List<com.yh.shenji.proxy.BaseProxy>>
     * @author : yangyihui
     * @date : 2019/11/13 15:33
     */
    private static Map<Class<?>, List<BaseProxy>> getProxyMap() {
        Map<Class<?>, List<BaseProxy>> result = Maps.newHashMap();
        return null;
    }
}
