#注解
## 重复注解
注解上必须使用@Repeatable注解，表示可以重复的
```java
@Repeatable(NoteContainer.class) //可以重复注解
@Retention(RetentionPolicy.RUNTIME)
@Target({CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
public @interface Note {
    String value() default "重复注解使用";
}
```
注意：重复注解在使用反射获取的时候必须使用getAnnotationsByType方法,否则报空指针
```java
//重复注解获取  method.getAnnotationsByType(Note.class)
 @Test
    public void hello() throws NoSuchMethodException {
        Class<TestAnnotation> clazz = TestAnnotation.class;

        Method method = clazz.getMethod("hello");
        Note[] note = method.getAnnotationsByType(Note.class);

        Arrays.stream(note)
                .map(Note::value)
                .forEach(System.out::println);
    }
    //普通注解获取 method.getAnnotation(Intro.class)
    @Test
    public void show() throws NoSuchMethodException {

        Class<TestAnnotation> clazz = TestAnnotation.class;

        Method method = clazz.getMethod("show");
        Intro intro = method.getAnnotation(Intro.class);

        System.out.println(intro.value());
    }

```

## 类型注解
jdk8添加了`TYPE_PARAMETER`和`TYPE_USE` 具体还没有使用