/**
 * Copyright(C) 2016 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.forkjoin.ForkJoinCalculate
 * @date: 2016-09-06 13:49
 * @des: forkjoin
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {

    private long start;
    private long end;
    //阈值
    private static final long threshold = 10000L;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        //到达阀值不拆，否则才开
        if (length <= threshold) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            //拆开
            long middle = (end + start) / 2;
            ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
            left.fork();//拆分子任务，加入线程队列

            ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
            right.fork();

            //合并
            return left.join() + right.join();
        }
    }
}
