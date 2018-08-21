/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.lambda;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.lambda.UppercaseFunction
 * @date: 2018-08-21 20:08
 * @des:
 */
@FunctionalInterface
public interface StringFunction {
    /**
     * 转大写
     *
     * @param str
     * @return
     */
    public String getValue(String str);
}
