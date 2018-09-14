# 接口
## 接口中的默认方法
原则：类优先，假如一个类跟接口中方法名称一样，类中的方法优先
```java
public interface Myfun {
    
    default String getName() {
        return "赵云";
    }
}
```