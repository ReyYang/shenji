package com.yh.shenji.proxy;

import java.lang.annotation.*;


/**
 * 自定义AOP 注解
 *
 * @author yang
 * @date 2019/11/25 15:24
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}
