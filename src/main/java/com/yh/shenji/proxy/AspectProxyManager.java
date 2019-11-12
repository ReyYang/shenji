package com.yh.shenji.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.List;

/**
 * Demo ProxyManager
 *
 * @author YangDongYu
 * @date 2019/11/12 17:06
 */
public class AspectProxyManager {

    @SuppressWarnings("all")
    public static <T> T getProxyInstance(final Class<T> targetClass, final List<BaseProxy> proxyList) {
        return (T) Enhancer.create(targetClass, (MethodInterceptor) (targetObject, method, params, methodProxy) ->
                new BaseProxy.ProxyChain(targetClass, targetObject, method, methodProxy, params, proxyList).doProxyChain());
    }
}
