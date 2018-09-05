#Stream(流)
[代码](https://github.com/zhaoyunxing92/java8-example/blob/master/src/test/java/com/sunny/jdk8/stream/StreamApiTest.java)
## 创建流
* 使用 collection（集合）提供的方法stream()或parallelStream()
 ```java
  List<Integer> list = new ArrayList<>();
  final Stream<Integer> stream = list.stream();
```
* 使用Arrays.stream()
```java
 User[] user = new User[10];
 final Stream<User> stream1 = Arrays.stream(user);
```
* 使用Stream的静态方法of()
```java
  Stream<String> stream2 = Stream.of("a", "b", "c");
```
## 流的使用
* filter 过滤
```java
    @Test
    public void test2() {
        users.stream()
                .filter((e) -> e.getAge() > 20)
                .forEach(System.out::println);
    }
```
* limit
```java
    @Test
    public void test3() {
        users.stream()
                .filter((e) -> e.getAge() > 20)
                .limit(2)
                .forEach(System.out::println);
    }
```
* skip 让掉第n个，超过几个大小了返回空
```java
    @Test
    public void test4() {
        users.stream()
                .filter((e) -> e.getAge() >= 18)
                .skip(1)
                .forEach(System.out::println);
    }
```
* distinct 去除重复，根据equals和hashCode去除重复
```java
    @Test
    public void test5() {
        users.stream()
                .filter((e) -> e.getAge() >= 18)
                .distinct()
                .forEach(System.out::println);
    }
```
* sorted 排序
```java
        @Test
        public void test7() {
            List<String> list = Arrays.asList("bbb", "aaa", "ccc", "ddd", "eee");
            //默认排序
            list.stream()
                    .sorted()
                    .forEach(System.out::println);
            System.out.println("-----------------------------------------");
            //定制排序
            users.stream()
                    .sorted((u1, u2) -> {
                        if (u1.getAge() >= u2.getAge())
                            return u1.getName().compareTo(u2.getName());
                        else
                            return u1.getName().compareTo(u2.getName());
                    })
                    .forEach(System.out::println);
    
        }
```
* max、min、count
```java
    // count
    @Test
    public void test4() {
        long count = users.stream()
                .count();
        System.out.println(count);
    }
    // max、min
     @Test
    public void test5() {
            Optional<User> op = users.stream()
                    .max(Comparator.comparingInt(User::getAge));
            System.out.println(op.get());
    
            Optional<User> op2 = users.stream()
                    .min(Comparator.comparingInt(User::getAge));
            System.out.println(op2.get());
    }

```
* reduce 归约 一个值反复结合，合并成一个
```java
    @Test
    public void test6() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
        System.out.println("------------------------------");
        //获取年龄合
        Optional<Integer> sumAge = users.stream()
                .map(User::getAge)
                .reduce(Integer::sum);
        System.out.println(sumAge.get());

    }
```
* collect 收集，流转为其他形式
```java
       @Test
       public void test7() {
           List<String> list = users.stream()
                   .map(User::getName)
                   .collect(Collectors.toList());
           System.out.println(list);
           System.out.println("--------------------------");
           Set<String> set = users.stream()
                   .map(User::getName)
                   .collect(Collectors.toSet());
           System.out.println(set);
           System.out.println("--------------------------");
           /*
            * 自定义的集合类型
            */
           HashSet<String> hashSet = users.stream()
                   .map(User::getName)
                   .collect(Collectors.toCollection(HashSet::new));
           System.out.println(hashSet);
           System.out.println("--------------------------");
   
           //求和
           Long collect = users.stream()
                   .collect(Collectors.counting());
           System.out.println(collect);
   
           //平均值
           Double avg = users.stream()
                   .collect(Collectors.averagingDouble(User::getAge));
           System.out.println(avg);
   
           //求合
           Integer sum = users.stream()
                   .collect(Collectors.summingInt(User::getAge));
           System.out.println(sum);
   
           //最大值
           Optional<User> op = users.stream()
                   .collect(Collectors.maxBy(Comparator.comparingInt(User::getAge)));
           System.out.println(op.get());
   
           //分组
           Map<Status, List<User>> groupMap = users.stream()
                   .collect(Collectors.groupingBy(User::getStatus));
           System.out.println(groupMap);
   
           //多级分组
           Map<Status, Map<String, List<User>>> collect1 = users.stream()
                   .collect(Collectors.groupingBy(User::getStatus, Collectors.groupingBy((u) -> {
                       if (u.getAge() <= 20) {
                           return "少年";
                       } else if (u.getAge() <= 30) {
                           return "青年";
                       } else {
                           return "老年";
                       }
                   })));
           System.out.println(collect1);
       }
```
* allMatch、anyMatch、noneMatch
```java
    @Test
    public void test1() {
        //是否匹配全部
        boolean b1 = users.stream()
                .allMatch(e -> e.getStatus().equals(Status.QUIT));
        System.out.println(b1);
        //是否匹配一个
        boolean b2 = users.stream()
                .anyMatch(e -> e.getStatus().equals(Status.QUIT));
        System.out.println(b2);
        //没有匹配一个
        boolean b3 = users.stream()
                .noneMatch(e -> e.getStatus().equals(Status.QUIT));
        System.out.println(b3);
    }
```
* findFirst、findAny
```java
    @Test
    public void test2() {
        //获取第一个元素
        Optional<User> op = users.stream()
                .sorted((u1, u2) -> -Integer.compare(u1.getAge(), u2.getAge()))
                .findFirst();
        System.out.println(op.get());
        //获取任意一个匹配的
        Optional<User> op = users.stream()
                        .filter(u -> u.getStatus().equals(Status.QUIT))
                        .findAny();
                System.out.println(op.get());
    }
```
* 分区 partitioningBy
```java
    @Test
    public void test8() {
        Map<Boolean, List<User>> listMap = users.stream()
                .collect(Collectors.partitioningBy((u) -> u.getAge() > 20));
        System.out.println(listMap);
    }
```
## 映射
* map 接收一个函数，该函数会映射到每个元素上
```java
       @Test
       public void test6() {
           List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
           list.stream()
                   .map(String::toUpperCase)
                   .forEach(System.out::println);
   
           System.out.println("-----------------------------------------");
           //获取集合用户名字
           users.stream()
                   .map(User::getName)
                   //   .distinct()
                   .forEach(System.out::println);
   
           System.out.println("-----------------------------------------");
   
           Stream<Stream<Character>> stream = list.stream()
                   .map(StreamApiTest::filterCharacter);
           stream.forEach((sm) -> sm.forEach(System.out::println));
       }
   
       public static Stream<Character> filterCharacter(String str) {
           List<Character> list = new ArrayList<>();
           for (Character ch : str.toCharArray()) {
               list.add(ch);
           }
           return list.stream();
       }
```
* flatMap 接收一个函数，将值转换为流，合成一个流
```java
        list.stream()
                .flatMap(StreamApiTest::filterCharacter)
                .forEach(System.out::println);
```