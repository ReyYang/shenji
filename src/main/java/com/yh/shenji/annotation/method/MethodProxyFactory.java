package com.yh.shenji.annotation.method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Demo MethodProxyFactory
 * method 包通用代理类
 * @author YangDongYu
 * @date 2019/11/8 16:29
 */
public class MethodProxyFactory implements MethodInterceptor {

    private Object target;

    private MethodProxyFactory(Object target) {
        this.target = target;
    }

    public MethodProxyFactory() {
    }

    public static <T> T getProxyInstance(Object target) {
        MethodProxyFactory factory = new MethodProxyFactory(target);
        return (T) Enhancer.create(target.getClass(), factory);
    }

    /**
     * 功能描述:
     * @param o cglib生成的代理对象
     * @param method 被代理对象方法
     * @param objects 方法入参
     * @param methodProxy 代理方法
     * @return : java.lang.Object
     * @author : yangyihui
     * @date : 2019/11/8 16:55
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        EnableCalculationMethodTime classAnnotation = target.getClass().getAnnotation(EnableCalculationMethodTime.class);
        if (Objects.nonNull(classAnnotation) && classAnnotation.isOpen()) {
            CalculationMethodTime annotation = method.getAnnotation(CalculationMethodTime.class);
            if (Objects.nonNull(annotation) && annotation.isOpen()) {
                System.out.println(annotation.prefix());
                long start = System.currentTimeMillis();
                Object invoke = method.invoke(target, objects);
                System.out.println(annotation.suffix() + " " + (System.currentTimeMillis() - start) + "ms");
                return invoke;
            }
        }
        return method.invoke(target, objects);
    }
}
