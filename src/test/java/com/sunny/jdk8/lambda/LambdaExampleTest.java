package com.sunny.jdk8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.lambda.LambdaExampleTest
 * @date: 2018-08-06 13:22
 * @des: lambda的演化过程
 */
public class LambdaExampleTest {
    /**
     * 初始化用户
     */
    private List<User> users = Arrays.asList(
            new User("王五", 25, 190),
            new User("赵六", 18, 175),
            new User("小明", 15, 168),
            new User("张三", 20, 180));

    /**
     * 过滤年龄大于20的人
     */
    @Test
    public void filterUserAgeGt20() {
        List<User> filterUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getAge() >= 20) {
                filterUsers.add(user);
            }
        }
        filterUsers.forEach(System.out::println);
    }
}