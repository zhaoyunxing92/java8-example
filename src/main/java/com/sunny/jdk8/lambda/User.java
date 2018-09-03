/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.lambda;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.lambda.User
 * @date: 2018-08-06 11:34
 * @des: 用户
 */
public class User {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 身高
     */
    private int height;
    /**
     * 状态
     */
    private Status status;

    private enum Status {
        STUDENT,//在校
        GRADUATE,//毕业
        QUIT;//休学
    }

    public User(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public User(String name, int age, int height, Status status) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.status = status;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (height != user.height) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return status == user.status;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + height;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", status=" + status +
                '}';
    }
}
