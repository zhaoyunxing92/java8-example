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