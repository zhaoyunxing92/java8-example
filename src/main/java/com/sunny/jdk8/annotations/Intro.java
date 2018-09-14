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
 * @class: com.sunny.jdk8.annotations.Intro
 * @date: 2018-09-14 14:32
 * @des:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE, TYPE_PARAMETER, TYPE_USE})
public @interface Intro {
    String value() default "";
}
