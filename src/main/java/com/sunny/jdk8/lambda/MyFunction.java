/**
 * Copyright(C) 2016 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.lambda;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.lambda.MyFunction
 * @date: 2016-08-21 20:21
 * @des:
 */
@FunctionalInterface
public interface MyFunction<T, R> {

    public R getValue(T t1, T t2);
}
