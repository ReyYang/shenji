package com.yh.shenji.annotation.method;


import java.lang.annotation.*;

/**
 * 计算方法时间注解
 *
 * @author yang
 * @date 2019/11/25 15:24
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CalculationMethodTime {
    boolean isOpen() default true;

    String prefix() default "计算方法时间：start";

    String suffix() default "计算方法时间：end";
}
