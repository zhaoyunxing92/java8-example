/**
 * Copyright(C) 2016 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.annotations;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.annotations.TestAnnotation
 * @date: 2016-09-14 13:50
 * @des:
 */
public class TestAnnotation {
    public Integer age;

    @Note("周瑜")
    @Note("公瑾")
    public void hello() {}

    @Intro("孙权")
    public void show() {}
}
