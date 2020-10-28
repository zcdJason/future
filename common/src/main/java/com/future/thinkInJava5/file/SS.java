package com.future.thinkInJava5.file;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Cock-a-doodle-doo!
 */
@Target(ElementType.FIELD) //应用在哪儿 方法？类？
@Retention(RetentionPolicy.SOURCE) // 保持在哪儿 源？ class文件？ 运行时
public @interface SS {
    int id();
    String desc() default "hello";
}
