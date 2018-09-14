/**
 * Copyright(C) 2016 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.lambda;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.lambda.HeightFilter
 * @date: 2016-08-06 16:39
 * @des: 身高过滤器 过滤身高大于等于180的
 */
public class HeightFilter implements Filter<User> {
    @Override
    public boolean matches(User obj) {
        return obj.getHeight() >= 180;
    }
}
