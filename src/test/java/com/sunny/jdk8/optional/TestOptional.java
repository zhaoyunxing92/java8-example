/**
 * Copyright(C) 2016 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.optional;

import com.sunny.jdk8.lambda.User;
import org.junit.Test;

import java.util.Optional;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.optional.TestOptional
 * @date: 2016-09-07 14:51
 * @des: Optional容器
 */
public class TestOptional {
    /**
     * of 不能构建null
     */
    @Test
    public void test1() {
        Optional<User> op = Optional.of(new User("张三", 25));
        User user = op.get();
        System.out.println(user);
    }

    /**
     * empty
     */
    @Test
    public void test2() {
        Optional<User> op = Optional.empty();
        System.out.println(op.get());
    }

    /**
     * ofNullable 可以构建null
     */
    @Test
    public void test3() {
        Optional<User> op = Optional.ofNullable(null);
        System.out.println(op.get());
    }

    /**
     * isPresent 判断是否可提取（是否为空）
     */
    @Test
    public void test4() {
        Optional<User> op = Optional.ofNullable(null);
        if (op.isPresent())
            System.out.println(op.get());
    }

    /**
     * orElse 有值就返回，没有值返回设置的对象
     */
    @Test
    public void test5() {
        Optional<User> op = Optional.ofNullable(null);
        User user = op.orElse(new User("张三", 25));
        System.out.println(user);
    }

    /**
     * orElseGet 跟orElse相同，只是函数式接口，自由度高点
     */
    @Test
    public void test6() {
        Optional<User> op = Optional.ofNullable(null);
        User user = op.orElseGet(() -> new User("张三", 25));
        System.out.println(user);
    }

    /**
     * map、flatMap
     */
    @Test
    public void test7() {
        Optional<User> op = Optional.ofNullable(new User("张三", 25));
        Optional<String> opName = op.map(User::getName);
        System.out.println(opName.get());

        Optional<String> optional = op.flatMap((u) -> Optional.of(u.getName()));
        System.out.println(optional.get());
    }
}
