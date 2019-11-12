package com.yh.shenji.annotation.method;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CalculationMethodTime {
    boolean isOpen() default true;

    String prefix() default "计算方法时间：start";

    String suffix() default "计算方法时间：end";
}
