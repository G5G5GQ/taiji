package com.mall.syslog.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author
 * @description 系统日志注解
 * @date 2023/05/25 10:33
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SysLog {

    /**
     * 入参日志打印
     * @return boolean
     */
    boolean input() default true;

    /**
     * 输出结果日志打印
     * @return boolean
     */
    boolean output() default false;
}
