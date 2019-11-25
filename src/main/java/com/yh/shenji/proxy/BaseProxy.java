package com.yh.shenji.proxy;

import lombok.Getter;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Demo BaseProxy
 * 代理基类
 *
 * @author YangDongYu
 * @date 2019/11/12 13:36
 */
public interface BaseProxy {

    /**
     * 功能描述: 抽象代理实现方法（代理链）
     * @param proxyChain 1
     * @return : java.lang.Object
     * @author : yangyihui
     * @date : 2019/11/25 15:23
     */
    <T> Object doProxy(ProxyChain<T> proxyChain);

    @Getter
    class ProxyChain<T> {
        //目标类
        private final Class<T> targetClass;
        private final T targetObject;
        private final Method method;
        private final MethodProxy methodProxy;
        private final Object[] params;

        private List<BaseProxy> proxyList;
        private int index = 0;

        public ProxyChain(Class<T> targetClass, T targetObject, Method method, MethodProxy methodProxy, Object[] params, List<BaseProxy> proxyList) {
            this.targetClass = targetClass;
            this.targetObject = targetObject;
            this.method = method;
            this.methodProxy = methodProxy;
            this.params = params;
            this.proxyList = proxyList;
        }

        public Object doProxyChain() throws Throwable {
            Object result;
            if (this.index >= proxyList.size()) {
                result = methodProxy.invokeSuper(targetObject, params);
                this.index = 0;
            } else {
                result = proxyList.get(this.index++).doProxy(this);
            }
            return result;
        }
    }
}

