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