/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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
        Consumer<String> con = System.out::println;
        // 只有一个情况下参数小括号可以省略
        // Consumer<String> con2 = x -> System.out.println(x);
        con.accept("hello");
    }

    /*有两个参数，有返回值的*/
    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("comparator");
            return Integer.compare(x, y);
        };
        int compare = com.compare(1, -1);
        System.out.println("compare:" + compare);

    }

    /*有两个参数，有返回值的,只有一条语句，return可以省略*/
    @Test
    public void test4() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        // ::语法
        // Comparator<Integer> com = Integer::compare;
        int compare = com.compare(1, -1);
        System.out.println("compare:" + compare);
    }

    /*参数类型可以省略不写，jvm自己推荐，但是要是写参数都必须写*/
    @Test
    public void test5() {
        Comparator<Integer> com = (Integer x, Integer y) -> Integer.compare(x, y);
        int compare = com.compare(1, -1);
        System.out.println("compare:" + compare);
    }
}
