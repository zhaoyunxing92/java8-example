/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.interfaces;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.interfaces.MyInterface
 * @date: 2018-09-14 11:01
 * @des:
 */
public interface MyInterface {
    default String getName() {
        return "鲁肃";
    }
}
