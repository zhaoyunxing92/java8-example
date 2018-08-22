/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.lambda;

import org.junit.Test;

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
        pay(100.2, (x) -> System.out.println("今天支出" + x + "元"));
    }

    private void pay(Double money, Consumer<Double> con) {
        con.accept(money);
    }

    /**
     * Supplier<T> 供给型接口（无参有返回值）
     */
    @Test
    public void test2() {
        List<Integer> list = getNumList(10, () -> (int) (Math.random() * 100));

        list.forEach(System.out::println);
    }

    /*产生数组*/
    private List<Integer> getNumList(Integer size, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Integer num = sup.get();
            list.add(num);
        }
        return list;
    }

    /**
     * Function<T, R> 函数式接口
     */
    @Test
    public void test3() {

        String str = strHandler("java", (x) -> x.replace("a", "h"));
        System.out.println(str);
    }

    /*字符串处理*/
    private String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    /**
     * Predicate<T> 断言型接口
     */
    @Test
    public void test4() {
        List<String> strs = Arrays.asList("java", "js", "go", "sql");

        List<String> strings = filterStr(strs, (str) -> str.length() > 2);

        strings.forEach(System.out::println);
    }

    /*集合过滤*/
    private List<String> filterStr(List<String> strs, Predicate<String> pre) {
        List<String> filterStr = new ArrayList<>();
        strs.forEach(str -> {
            if (pre.test(str))
                filterStr.add(str);
        });
        return filterStr;
    }

}
