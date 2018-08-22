/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.lambda.LambdaExampleTest2
 * @date: 2018-08-09 17:08
 * @des: 四大内置函数接口
 * * Consumer<T> 消费型接口 (有参无返回值)
 * * Supplier<T> 供给型接口（无参有返回值）
 * * Function<T, R> 函数式接口
 * * Predicate<T> 断言型接口
 */
public class LambdaExampleTest3 {

    /**
     * Consumer<T> 消费型接口 (有参无返回值)
     */
    @Test
    public void test1() {
        pay(100.2, (x) -> System.out.println("今天收益" + x + "元"));
    }

    private void pay(Double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test2() {

    }

    @Test
    public void test3() {

    }

    @Test
    public void test4() {

    }

    @Test
    public void test5() {

    }
}
