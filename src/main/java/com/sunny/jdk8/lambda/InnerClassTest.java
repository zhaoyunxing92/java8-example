/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.lambda;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.lambda.InnerClassTest
 * @date: 2018-08-09 17:38
 * @des:
 */
public class InnerClassTest {
    private double radius = 0;
    public static int count = 1;

    public InnerClassTest(double radius) {
        this.radius = radius;
    }

    class Draw {     //内部类
        public void drawSahpe() {
            System.out.println(radius);  //外部类的private成员
            System.out.println(count);   //外部类的静态成员
        }
    }

    public static void main(String[] args) {

    }
}
