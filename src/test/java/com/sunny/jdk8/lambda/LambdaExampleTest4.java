/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.lambda.LambdaExampleTest2
 * @date: 2018-08-09 17:08
 * @des: 方法引用：若Lambda体的内容方法已经实现了，可以使用方法引用
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

        con = out::println;

        con = System.out::println;

        con.accept("java");
    }


    /**
     * Supplier<T> 供给型接口（无参有返回值）
     */
    @Test
    public void test2() {

    }


    /**
     * Function<T, R> 函数式接口
     */
    @Test
    public void test3() {


    }


    /**
     * Predicate<T> 断言型接口
     */
    @Test
    public void test4() {

    }


}
