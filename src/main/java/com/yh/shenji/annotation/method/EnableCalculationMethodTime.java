package com.yh.shenji.annotation.method;

import java.lang.annotation.*;

/**
 * @author yang
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableCalculationMethodTime {
    boolean isOpen() default true;
}
