/**
 * Copyright(C) 2016 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.interfaces;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.interfaces.SubClass
 * @date: 2016-09-14 10:30
 * @des:
 */
public class SubClass2 implements Myfun, MyInterface {
    @Override
    public String getName() {
        return MyInterface.super.getName();
    }
}
