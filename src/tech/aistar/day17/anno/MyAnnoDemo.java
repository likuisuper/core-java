package tech.aistar.day17.anno;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 本类功能:通过反射的技术可以获取注解的信息
 *
 * @author cxylk
 * @date 2020/8/19 19:44
 */
public class MyAnnoDemo {
    public static void main(String[] args) {
        //1.获取class实例
        Class<?> c=TestMyAnno.class;

        //判断type类型上是否添加了注解
        if(c.isAnnotationPresent(MyAnno.class)){
            //获取注解对应的Annotation对象
            MyAnno anno=c.getDeclaredAnnotation(MyAnno.class);

            //获取注解设置的值
            String[] result=anno.value();

            System.out.println(Arrays.toString(result));//[java, python]
        }else{
            System.out.println("type上没有添加注解");
        }

        System.out.println("====获取方法上配置的注解的信息=====");

        //确定获取的是哪个方法上的注解
        //根据方法的名称以及方法的形参来得到这个方法对应的Method对象
        try {
            Method m=c.getDeclaredMethod("test");

            //1.判断一下方法山是否增加了注解
            if(m.isAnnotationPresent(MyAnno.class)){
                MyAnno myAnno=m.getDeclaredAnnotation(MyAnno.class);

                String[] results=myAnno.value();

                System.out.println(Arrays.toString(results));//[java2, python2]
            }else {
                System.out.println("方法上没有添加注解");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
