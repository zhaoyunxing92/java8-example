/**
 * Copyright(C) 2016 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.annotations.Note
 * @date: 2016-09-14 13:54
 * @des:
 */
@Repeatable(NoteContainer.class) //可以重复注解
@Retention(RetentionPolicy.RUNTIME)
@Target({CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
public @interface Note {
    String value() default "重复注解使用";
}
