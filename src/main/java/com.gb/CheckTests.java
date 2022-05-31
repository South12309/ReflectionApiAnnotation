package com.gb;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class CheckTests {

    public static void main(String[] args) {
        start(TestClass.class);
    }


    public static <T> void start(String clazzName) {
        try {
            start(Class.forName(clazzName));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static <T> void start(Class<T> clazz) {
        Method beforeSuite=null;
        Method afterSuite=null;
        T instance = null;
        ArrayList<Method> methodsList = new ArrayList<>();
        try {
            instance = clazz.getConstructor().newInstance();
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(BeforeSuite.class)) {
                    if (beforeSuite != null)
                        throw new RuntimeException("Методов с аннотиацией BeforSuite больше одного");
                    beforeSuite = method;
                }

                if (method.isAnnotationPresent(AfterSuite.class)) {
                    if (afterSuite != null)
                        throw new RuntimeException("Методов с аннотиацией BeforSuite больше одного");
                    afterSuite = method;
                }

                if (method.isAnnotationPresent(Test.class)) {
                    methodsList.add(method);
                }


            }

            methodsList.sort((method1, method2) -> method1.getAnnotation(Test.class).number() - method2.getAnnotation(Test.class).number());

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            if (beforeSuite != null)
                beforeSuite.invoke(instance);

            for (Method method : methodsList) {
                method.invoke(instance);
            }

            if (afterSuite != null)
                afterSuite.invoke(instance);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
