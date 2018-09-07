# forkjoin
Fork/Join框架：在必要的情况下，将一个大任务，进行拆分（fork） 成若干个子任务（拆到不能再拆，这里就是指我们制定的拆分的临界值），再将一个个小任务的结果进行join汇总。Fork/Join采用“工作窃取模式”，当执行新的任务时他可以将其拆分成更小的任务执行，并将小任务加到线程队列中，然后再从一个随即线程中偷一个并把它加入自己的队列中。
## 代码
* 自己实现需要继承RecursiveTask或RecursiveAction类（有返回值和无返回值的区别）
```java
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
//测试
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
```
* jdk8 Stream API可以声明性的通过parallel()与sequential()在并行流与穿行流中随意切换！
```java
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
```