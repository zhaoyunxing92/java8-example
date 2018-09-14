package com.sunny.jdk8.annotations;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.annotations.TestAnnotationTest
 * @date: 2016-09-14 14:26
 * @des:
 */
public class TestAnnotationTest {

    @Test
    public void hello() throws NoSuchMethodException {
        Class<TestAnnotation> clazz = TestAnnotation.class;

        Method method = clazz.getMethod("hello");
        Note[] note = method.getAnnotationsByType(Note.class);

        Arrays.stream(note)
                .map(Note::value)
                .forEach(System.out::println);
    }

    @Test
    public void show() throws NoSuchMethodException {

        Class<TestAnnotation> clazz = TestAnnotation.class;

        Method method = clazz.getMethod("show");
        Intro intro = method.getAnnotation(Intro.class);

        System.out.println(intro.value());
    }
}