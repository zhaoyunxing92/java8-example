/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.stream;

import com.sunny.jdk8.lambda.User;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.stream.StreamApiTest
 * @date: 2018-08-24 14:03
 * @des: Stream(流)操作
 */
public class StreamApiTest {

    @Test
    public void test1() {
        //1.流创建
        //1.1 使用 collection（集合）提供的方法stream()或parallelStream()
        List<Integer> list = new ArrayList<>();
        final Stream<Integer> stream = list.stream();

        //1.2 使用Arrays.stream()
        User[] user = new User[10];
        final Stream<User> stream1 = Arrays.stream(user);

        //1.3 使用Stream的静态方法of()
        Stream<String> stream2 = Stream.of("a", "b", "c");

        //1.4 无限流
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2);
        stream3.limit(10).forEach(System.out::println);

        //1.5 生成
        Stream<Double> generate = Stream.generate(() -> Math.random());
        generate.limit(5)
                .forEach(System.out::println);

    }

    private List<User> users = Arrays.asList(
            new User("小明", 21, 168),
            new User("王五", 25, 190),
            new User("赵六", 18, 175),
            new User("赵六", 18, 175),
            new User("赵六", 18, 175),
            new User("赵六", 18, 175),
            new User("赵六", 18, 175),
            new User("王明", 21, 170),
            new User("张三", 15, 180));

    // filter 过滤
    @Test
    public void test2() {
        users.stream()
                .filter((e) -> e.getAge() > 20)
                .forEach(System.out::println);
    }

    //limit
    @Test
    public void test3() {
        users.stream()
                .filter((e) -> e.getAge() > 20)
                .limit(2)
                .forEach(System.out::println);
    }

    //skip,让掉第n个，超过几个大小了返回空
    @Test
    public void test4() {
        users.stream()
                .filter((e) -> e.getAge() >= 18)
                .skip(1)
                .forEach(System.out::println);
    }

    //distinct,去除重复，根据equals和hashCode去除重复
    @Test
    public void test5() {
        users.stream()
                .filter((e) -> e.getAge() >= 18)
                .distinct()
                .forEach(System.out::println);
    }

    //映射

    /**
     * map 接受一个函数，该函数会映射到每个元素上
     */
    @Test
    public void test6() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("-----------------------------------------");
        //获取集合用户名字
        users.stream()
                .map(User::getName)
                //   .distinct()
                .forEach(System.out::println);

        System.out.println("-----------------------------------------");
        Stream<Stream<Character>> stream = list.stream()
                .map(StreamApiTest::filterCharacter);
        stream.forEach((sm) -> sm.forEach(System.out::println));
    }

    private static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }
}
