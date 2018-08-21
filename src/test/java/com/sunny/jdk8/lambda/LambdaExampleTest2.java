/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.lambda;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.lambda.LambdaExampleTest2
 * @date: 2018-08-09 17:08
 * @des: lambda 语法测试
 */
public class LambdaExampleTest2 {

    /*无参数、无返回值*/
    @Test
    public void test1() {
        int num = 5;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello test1" + num);
            }
        };
        runnable.run();
        System.out.println("---------------------------------");
        Runnable r = () -> System.out.println("hello test1-1");
        r.run();
    }

    /*有参数，无返回值*/
    @Test
    public void test2() {
        Consumer<String> con = (x) -> System.out.println(x);
        // 只有一个情况下参数小括号可以省略
        // Consumer<String> con2 = x -> System.out.println(x);
        con.accept("hello");
    }
}
