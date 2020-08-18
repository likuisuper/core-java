package tech.aistar.day17;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * 本类功能:反射调用构造方法
 *
 * @author cxylk
 * @date 2020/8/18 18:49
 */
public class ConstructorDemo {
    public static void main(String[] args) {
        //获取class实例
        Class<?> c=Point.class;

        //获取所有的构造
        Constructor<?>[] constructors=c.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            //System.out.println(constructor);
            System.out.print(Modifier.toString(constructor.getModifiers())+" ");
            System.out.print(constructor.getName()+"(");

            Class<?>[] types=constructor.getParameterTypes();

            for (int i = 0; i < types.length; i++) {
                System.out.println((i!=types.length-1)?(types[i].getSimpleName()+","):(types[i].getSimpleName()));
            }
            System.out.println(")");

            System.out.println("===反射调用构造");
            //1.调用空参构造有两种方式
            //a.直接通过java.lang.Class<T>中提供的newInstance()
            try {
                Point p= (Point) c.newInstance();

                //b.通过java.lang.reflect.Constructor提供的newInstance
                Constructor<?> c1=c.getDeclaredConstructor();
                Point p2= (Point) c1.newInstance();

                //2.调用带参构造只有一种
                Constructor<?> c2=c.getDeclaredConstructor(int.class,String.class);
                //c2.setAccessible(true);//如果该构造方法是private的
                Point p3= (Point) c2.newInstance(200,"java");

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
