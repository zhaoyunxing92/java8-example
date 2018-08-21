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
* 有参数，无返回值
```java
  @Test
    public void test2() {
              Consumer<String> con = (x) -> System.out.println(x);
              // 只有一个情况下参数小括号可以省略
              // Consumer<String> con2 = x -> System.out.println(x);
              con.accept("hello");
    }
```
* 有两个参数，有返回值的
```java
  @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            return Integer.compare(x, y);
        };
        int compare = com.compare(1, -1);
        System.out.println("compare:" + compare);

    }
```