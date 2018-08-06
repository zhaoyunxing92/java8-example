/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.lambda;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.lambda.AgeFilter
 * @date: 2018-08-06 16:34
 * @des: 年龄过滤器
 */
public class AgeFilter implements Filter<User> {
    @Override
    public boolean matches(User user) {
        return user.getAge() >= 20;
    }
}
