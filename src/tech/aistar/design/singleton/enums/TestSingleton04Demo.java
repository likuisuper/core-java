package tech.aistar.design.singleton.enums;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/5 20:41
 */
public class TestSingleton04Demo {
    public static void main(String[] args) {
        Singleton04Demo s1=Singleton04Demo.getInstance();
        Singleton04Demo s2=Singleton04Demo.getInstance();
        System.out.println(s1==s2);

        System.out.println("==========");

        //java.Lang.Class<T> 是反射技术的基础类
        Class<?> c=Singleton04Demo.class;

        try {
            Constructor<?> constructor=c.getDeclaredConstructor();

            //反射技术同时也是可以破坏封装性的
            constructor.setAccessible(true);

            //反射技术来构建一个类的对象
            Singleton04Demo s3= (Singleton04Demo) constructor.newInstance();

            System.out.println(s1==s3);//false

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
