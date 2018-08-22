# Lambda 基础语法

## 规则
左侧：参数列表
右侧：函数体。
需要函数式接口的支持
> 函数式接口即只有一个抽象方法的接口，可以使用`@FunctionalInterface`注解修饰
## 语法
> [代码](https://github.com/zhaoyunxing92/java8-example/blob/master/src/test/java/com/sunny/jdk8/lambda/LambdaExampleTest2.java)
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
* 有两个参数，有返回值的,只有一条语句，return可以省略
```java
 @Test
    public void test4() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        // ::语法
        // Comparator<Integer> com = Integer::compare;
        int compare = com.compare(1, -1);
        System.out.println("compare:" + compare);
    }
```
* 参数类型可以省略不写，jvm自己推荐，但是要是写参数都必须写
```java
 @Test
    public void test5() {
        Comparator<Integer> com = (Integer x, Integer y) -> Integer.compare(x, y);
        int compare = com.compare(1, -1);
        System.out.println("compare:" + compare);
    }
```
## 四大内置函数接口
> [代码](https://github.com/zhaoyunxing92/java8-example/blob/master/src/test/java/com/sunny/jdk8/lambda/LambdaExampleTest3.java)
 * Consumer<T> 消费型接口 (有参无返回值)
 ```java
 void accept(T t);
// eg
Consumer<String> con = System.out::println;
// 只有一个情况下参数小括号可以省略
// Consumer<String> con2 = x -> System.out.println(x);
con.accept("hello");
```
* Supplier<T> 供给型接口（无参有返回值）
```java
T get();
// eg
Supplier<String> supplier = () -> "java";
supplier.get();
```
* Function<T, R> 函数式接口 
```java
    R apply(T t);
```
* Predicate<T> 断言型接口  
```java
  boolean test(T t);
```
 ### 完整demo
 ```java
 /**
     * Consumer<T> 消费型接口 (有参无返回值)
     */
    @Test
    public void test1() {
        pay(100.2, (x) -> System.out.println("今天收益" + x + "元"));
    }

    private void pay(Double money, Consumer<Double> con) {
        con.accept(money);
    }

    /**
     * Supplier<T> 供给型接口（无参有返回值）
     */
    @Test
    public void test2() {
        List<Integer> list = getNumList(10, () -> (int) (Math.random() * 100));

        list.forEach(System.out::println);
    }

    /*产生数组*/
    private List<Integer> getNumList(Integer size, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Integer num = sup.get();
            list.add(num);
        }
        return list;
    }

    /**
     * Function<T, R> 函数式接口
     */
    @Test
    public void test3() {
 
        String str = strHandler("java", (x) -> x.replace("a", "h"));
        System.out.println(str);
    }

    /*字符串处理*/
    private String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    /**
     * Predicate<T> 断言型接口
     */
    @Test
    public void test4() {
        List<String> strs = Arrays.asList("java", "js", "go", "sql");

        List<String> strings = filterStr(strs, (str) -> str.length() > 2);

        strings.forEach(System.out::println);
    }

    /*集合过滤*/
    private List<String> filterStr(List<String> strs, Predicate<String> pre) {
        List<String> filterStr = new ArrayList<>();
        strs.forEach(str -> {
            if (pre.test(str))
                filterStr.add(str);
        });
        return filterStr;
    }
```