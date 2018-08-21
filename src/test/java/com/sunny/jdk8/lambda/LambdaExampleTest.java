package com.sunny.jdk8.lambda;

import org.junit.Test;

import java.util.*;


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
            new User("小明", 21, 168),
            new User("王五", 25, 190),
            new User("赵六", 18, 175),

            new User("王明", 21, 170),
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
     * 使用lambda优化代码
     */
    @Test
    public void filterUser5() {
        List<User> filterUsers = filerUsersByFilter(users, obj -> obj.getHeight() >= 175);
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

    /**
     * 需求：
     * 1.先按照年龄比
     * 2.年龄相等按照身高比
     * 倒序
     */
    @Test
    public void test2() {
        Collections.sort(users, (u1, u2) -> {
            if (u1.getAge() == u2.getAge()) {
                return -Integer.compare(u1.getHeight(), u2.getHeight());
            } else {
                return -Integer.compare(u1.getAge(), u2.getAge());
            }
        });
        users.forEach(System.out::println);
    }

    @Test
    public void test3() {
        String str = strHandler("  java  ", (s) -> s.trim());
        System.out.println("str:" + str);
    }

    @Test
    public void test4() {
        operation(100, 200, (x, y) -> x + y);
    }

    //对字符串处理
    private String strHandler(String str, StringFunction sf) {
        return sf.getValue(str);
    }

    //对两个int运算
    private void operation(Integer l1, Integer l2, MyFunction<Integer, Integer> fn) {
        System.out.println(fn.getValue(l1, l2));
    }
}