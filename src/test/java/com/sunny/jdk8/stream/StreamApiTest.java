/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.stream;

import com.sunny.jdk8.lambda.User;
import org.junit.Test;

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
    }
}
