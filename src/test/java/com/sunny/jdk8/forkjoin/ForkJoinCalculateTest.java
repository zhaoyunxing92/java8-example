package com.sunny.jdk8.forkjoin;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import static org.junit.Assert.*;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.forkjoin.ForkJoinCalculateTest
 * @date: 2016-09-06 16:47
 * @des:
 */
public class ForkJoinCalculateTest {

    @Test
    public void compute() {
        Instant start = Instant.now();
        //创建池子
        ForkJoinPool pool = new ForkJoinPool();
        //创建任务
        ForkJoinTask<Long> task = new ForkJoinCalculate(1, 50000000000L);
        //执行
        Long sum = pool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();

        System.out.println("耗时：" + Duration.between(start, end).toMillis());//5199
    }

    @Test
    public void test2() {
        Instant start = Instant.now();
        long sum = 0L;
        for (long i = 0l; i <= 50000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis());//36394
    }

    /**
     * 使用并行流处理
     */
    @Test
    public void test3() {
        Instant start = Instant.now();
        long sum = LongStream.rangeClosed(0, 50000000000L)
                .parallel()
                .reduce(0, Long::sum);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis());//15782
    }
}