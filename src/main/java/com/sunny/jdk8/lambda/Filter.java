/**
 * Copyright(C) 2016 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.lambda;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.lambda.Filter
 * @date: 2016-08-06 16:31
 * @des:
 */
@FunctionalInterface
public interface Filter<T> {
    /**
     * 对对象操作
     * @param obj
     * @return
     */
    public boolean matches(T obj);
}
