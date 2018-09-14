/**
 * Copyright(C) 2016 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.interfaces;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.interfaces.Myfun
 * @date: 2016-09-13 10:20
 * @des:
 */
public interface Myfun {

    default String getName() {
        return "赵云";
    }

    static void say() {
        System.out.println("接口中的静态方法");
    }
}
