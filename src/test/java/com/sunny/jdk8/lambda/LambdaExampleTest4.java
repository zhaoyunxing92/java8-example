/**
 * Copyright(C) 2016 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.lambda.LambdaExampleTest2
 * @date: 2016-08-09 17:08
 * @des: 方法引用：若Lambda体的内容方法已经实现了，可以使用方法引用
 * 方法参数类型和返回类型跟函数方法必须相同
 * 主要三种语法格式：
 * 对象::实力方法名
 * 类::静态方法名
 * 类::实例方法名
 */
public class LambdaExampleTest4 {

    /**
     * 对象::实力方法名
     */
    @Test
    public void test1() {
        PrintStream out = System.out;
        Consumer<String> con = (x) -> out.println(x);

        Consumer<String> con1 = out::println;

        Consumer<String> con2 = System.out::println;

        con.accept("java");
        con1.accept("java1");
        con2.accept("java2");
    }


    /**
     * 类::实例方法名
     */
    @Test
    public void test2() {
        User user = new User("张三", 25);

        Supplier<String> sup = () -> user.getName();
        String name = sup.get();
        System.out.println(name);

        Supplier<Integer> sup2 = user::getAge;
        Integer integer = sup2.get();
        System.out.println(integer);

    }


    /**
     * 类::静态方法名
     */
    @Test
    public void test3() {
        Comparator<Integer> cp = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> cp2 = Integer::compare;

    }

}
