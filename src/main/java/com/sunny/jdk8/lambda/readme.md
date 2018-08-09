# Lambda 基础语法
## 规则
左侧：参数列表
右侧：函数体

## 语法
* 无参数、无返回值
```java
 /*无参数、无返回值*/
    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello test1");
            }
        };
        runnable.run();
        System.out.println("---------------------------------");
        Runnable r = () -> System.out.println("hello test1-1");
        r.run();
    }
```
