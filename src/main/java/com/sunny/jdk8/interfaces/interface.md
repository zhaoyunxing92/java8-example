# 接口
## 接口中的默认方法

```java
public interface Myfun {
    
    default String getName() {
        return "赵云";
    }
}
// 两个接口同时都是该方法
public class SubClass2 implements Myfun, MyInterface {
    @Override
    public String getName() {
        return MyInterface.super.getName();
    }
}
```
> 原则
* 类优先，假如一个类跟接口中方法名称一样，类中的方法优先
* 一个类同时实现两个或多个接口，如果默认的方法相同，这个必须指定要实现的方法

## 接口中的静态方法
