/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.annotations.NoteContatiner
 * @date: 2018-09-14 14:07
 * @des: 容器注解类
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
public @interface NoteContainer {
    Note[] value();
}
