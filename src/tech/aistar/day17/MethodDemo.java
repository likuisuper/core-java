package tech.aistar.day17;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 本类功能:getter/setter方法
 *
 * @author cxylk
 * @date 2020/8/18 16:30
 */
public class MethodDemo {
    public static void main(String[] args) {
        //1.获取class实例
        try {
            Class<?> c=Class.forName("tech.aistar.day17.Point");
            //获取类或接口中声明的所有方法(不包括构造和继承的方法)
            Method[] methods=c.getDeclaredMethods();
            System.out.println(methods.length);//获取方法个数

            for (Method method : methods) {
                //System.out.println(method);//不包含构造方法

                //获取方法的元 信息
                //1.获取方法的修饰符
                //System.out.print(Modifier.toString(method.getModifiers())+" ");

                //2.获取方法的返回类型
                //System.out.print(method.getReturnType().getSimpleName()+" ");

                //3.获取方法的名称
                System.out.println(method.getName()+"(");

                //4.获取方法的形参列表
                Class<?>[] types=method.getParameterTypes();

                for (int i = 0; i < types.length; i++) {
                    System.out.println((i!=types.length-1)?(types[i].getSimpleName()+","):(types[i].getSimpleName()));
                }
                System.out.println(")");

                System.out.println("===获取指定的方法====");
                //反射创建Point对象
                Point p= (Point) c.newInstance();//会调用空参构造

                //1.获取空参的test方法
                Method m1=c.getDeclaredMethod("test");
                //1-1.反射调用
                m1.invoke(p);

                //2.反射调用一参的test方法
                Method m2=c.getDeclaredMethod("test",int.class);
                m2.invoke(p,100);

                //3.反射调用两参test方法
                Method m3=c.getDeclaredMethod("test",int.class,String.class);
                m3.invoke(p,200,"iuk");

                //4.调用静态方法
                Method m4=c.getDeclaredMethod("testStatic");
                m4.invoke(p);

                //5.调用私有的方法 - 反射可以破坏封装性
                Method m5=c.getDeclaredMethod("testPrivate");
                m5.setAccessible(true);
                m5.invoke(p);

                //6.调用带有返回类型的方法
                Method m6=c.getDeclaredMethod("getResult");
                String result= (String) m6.invoke(p);
                System.out.println(result);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
