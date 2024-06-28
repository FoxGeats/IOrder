package com.sky.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.sky.enumeration.OperationType;

/*
 * 自定义注释，用于标识某个方法需要进行功能字段自动填充处理
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
// 使用@Retention必须要为value指定成员变量的值，该成员变量为一个容器注解，这个容器注解包含多个OperationType
public @interface AutoFill {
    //数据库操作类型：insert、update
    OperationType value();
}
