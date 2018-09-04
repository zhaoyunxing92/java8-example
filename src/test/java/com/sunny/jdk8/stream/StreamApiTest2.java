/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.stream;

import com.sunny.jdk8.lambda.Status;
import com.sunny.jdk8.lambda.User;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.stream.StreamApiTest
 * @date: 2018-08-24 14:03
 * @des: 终止操作
 */
public class StreamApiTest2 {
    private List<User> users = Arrays.asList(
            new User("小明", 21, 168, Status.QUIT),
            new User("王五", 25, 190, Status.GRADUATE),
            new User("赵六", 18, 175, Status.STUDENT),
            new User("王明", 28, 170, Status.QUIT),
            new User("张三", 15, 180, Status.STUDENT));

    /**
     * allMatch 是否匹配全部
     * anyMatch 是否匹配一个
     * noneMatch 没有匹配一个
     */
    @Test
    public void test1() {
        boolean b1 = users.stream()
                .allMatch(e -> e.getStatus().equals(Status.QUIT));
        System.out.println(b1);

        boolean b2 = users.stream()
                .anyMatch(e -> e.getStatus().equals(Status.QUIT));
        System.out.println(b2);

        boolean b3 = users.stream()
                .noneMatch(e -> e.getStatus().equals(Status.QUIT));
        System.out.println(b3);
    }

    /**
     * findFirst 获取第一个元素，年龄最大的
     */
    @Test
    public void test2() {
        Optional<User> op = users.stream()
                .sorted((u1, u2) -> -Integer.compare(u1.getAge(), u2.getAge()))
                .findFirst();
        System.out.println(op.get());
    }

    /**
     * findAny 获取任意一个匹配的
     */
    @Test
    public void test3() {
        Optional<User> op = users.stream()
                .filter(u -> u.getStatus().equals(Status.QUIT))
                .findAny();
        System.out.println(op.get());
    }

    /**
     * count
     */
    @Test
    public void test4() {
        long count = users.stream()
                .count();
        System.out.println(count);
    }

    /**
     * max min年龄最大的
     */
    @Test
    public void test5() {
        Optional<User> op = users.stream()
                .max(Comparator.comparingInt(User::getAge));
        System.out.println(op.get());

        Optional<User> op2 = users.stream()
                .min(Comparator.comparingInt(User::getAge));
        System.out.println(op2.get());
    }

    /**
     * 归约，一个值反复结合，合并成一个
     */
    @Test
    public void test6() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
        System.out.println("------------------------------");
        //获取年龄合
        Optional<Integer> sumAge = users.stream()
                .map(User::getAge)
                .reduce(Integer::sum);
        System.out.println(sumAge.get());

    }

    /**
     * 收集 collect 流转为其他形式
     */
    @Test
    public void test7() {
        List<String> list = users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
        System.out.println(list);
        System.out.println("--------------------------");
        Set<String> set = users.stream()
                .map(User::getName)
                .collect(Collectors.toSet());
        System.out.println(set);
    }
}
