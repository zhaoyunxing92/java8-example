/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.interfaces;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.interfaces.Myfun
 * @date: 2018-09-13 10:20
 * @des:
 */
public interface Myfun {
    default String getName() {
        return "赵云";
    }
}
