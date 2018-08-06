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
            new User("小明", 21, 168),
            new User("张三", 15, 180));

    /**
     * 过滤年龄大于等于20的人
     */
    @Test
    public void filterUser1() {
        List<User> filterUsers = filerUsersAgeGt20(users);
        filterUsers.forEach(System.out::println);
    }

    /**
     * 通过策略模式优化代码
     */
    @Test
    public void filterUser2() {
        List<User> filterUsers = filerUsersByFilter(users, new AgeFilter());
        filterUsers.forEach(System.out::println);
    }

    /**
     * 过滤身高大于等于180的
     */
    @Test
    public void filterUser3() {
        List<User> filterUsers = filerUsersByFilter(users, new HeightFilter());
        filterUsers.forEach(System.out::println);
    }

    /**
     * 使用匿名内部类，减少无用的类
     */
    @Test
    public void filterUser4() {
        List<User> filterUsers = filerUsersByFilter(users, new Filter<User>() {
            @Override
            public boolean matches(User obj) {
                return obj.getHeight() >= 175;
            }
        });
        filterUsers.forEach(System.out::println);
    }

    /**
     * 1.存在硬编码，代码不够灵活
     *
     * @param users 用户
     * @return 符合条件的用户
     */
    private List<User> filerUsersAgeGt20(List<User> users) {
        List<User> filterUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getAge() >= 20) {
                filterUsers.add(user);
            }
        }
        return filterUsers;
    }

    /**
     * 2.采用策略模式优化代码，但是需要一堆的策略
     *
     * @param users  用户
     * @param filter 过滤器
     * @return
     */
    private List<User> filerUsersByFilter(List<User> users, Filter<User> filter) {
        List<User> filterUsers = new ArrayList<>();
        for (User user : users) {
            if (filter.matches(user)) {
                filterUsers.add(user);
            }
        }
        return filterUsers;
    }


}