/**
 * Copyright(C) 2016 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.interfaces;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.interfaces.Main
 * @date: 2016-09-14 10:31
 * @des:
 */
public class Main {
    public static void main(String[] args) {
        SubClass sc = new SubClass();
        System.out.println(sc.getName());

        SubClass2 class2 = new SubClass2();
        System.out.println(class2.getName());

        Myfun.say();
    }
}
