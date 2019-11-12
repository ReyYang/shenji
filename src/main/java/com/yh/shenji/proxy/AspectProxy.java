package com.yh.shenji.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * Demo AspectProxy
 *
 * @author YangDongYu
 * @date 2019/11/12 16:31
 */
@Slf4j
public class AspectProxy implements BaseProxy {

    @Override
    public <T> Object doProxy(ProxyChain<T> proxyChain) {
        Class<T> targetClass = proxyChain.getTargetClass();
        Method method = proxyChain.getMethod();
        Object[] params = proxyChain.getParams();
        Object result;
        try {
            if (intercept(targetClass, method, params)) {
                before(targetClass, method, params);
                result = proxyChain.doProxyChain();
                after(targetClass, method, params);
            } else {
                result = proxyChain.doProxyChain();
            }
        } catch (Throwable e) {
           error(targetClass, method, params);
           log.error("AspectProxy FAIL", e);
           throw new RuntimeException(e);
        } finally {
            end();
        }
        return result;
    }

    /**
     * 功能描述: 重写此以实现 拦截条件
     *
     * @param targetClass 1
     * @param method      2
     * @param params      3
     * @return : boolean
     * @author : yangyihui
     * @date : 2019/11/12 16:43
     */
    protected <T> boolean intercept(Class<T> targetClass, Method method, Object[] params) {
        return true;
    }

    /**
     * 功能描述: 重写此以实现 前置增强
     *
     * @param targetClass 1
     * @param method      2
     * @param params      3
     * @return : void
     * @author : yangyihui
     * @date : 2019/11/12 16:43
     */
    protected <T> void before(Class<T> targetClass, Method method, Object[] params) {

    }

    /**
     * 功能描述: 重写此以实现 后置增强
     *
     * @param targetClass 1
     * @param method      2
     * @param params      3
     * @return : void
     * @author : yangyihui
     * @date : 2019/11/12 16:43
     */
    protected <T> void after(Class<T> targetClass, Method method, Object[] params) {

    }

    /**
     * 功能描述: 重写此以实现 抛出增强
     *
     * @param targetClass 1
     * @param method      2
     * @param params      3
     * @return : void
     * @author : yangyihui
     * @date : 2019/11/12 16:43
     */
    protected <T> void error(Class<T> targetClass, Method method, Object[] params) {

    }

    /**
     * 功能描述: 重写此以实现 "结束增强"
     *
     * @author : yangyihui
     * @date : 2019/11/12 16:43
     */
    protected void end() {

    }


}
