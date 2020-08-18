package tech.aistar.day17;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 本类功能:反射获取字段信息
 *
 * @author cxylk
 * @date 2020/8/18 9:20
 */
public class FieldDemo {
    public static void main(String[] args) {
        //1.获取类的class实例 - 只能获取，不能创建
        //反射技术的基础类
        Class<?> c=Point.class;

        //2.获取所有公开的字段
        //Field[] fields=c.getFields();

        //2-1 常用的 - 获取所有的属性，包括私有的包括继承下来的

        Field[] fields=c.getDeclaredFields();

        for (Field field : fields) {
            //字段的元信息 - 修饰符 属性的数据类型 属性名
            //public int tech.aistar.day17.Point.z
            //System.out.println(field);

            //常用方法
            //System.out.println(field.getModifiers());//打印出来的是数字

            //反射获取修饰符
            //System.out.print(Modifier.toString(field.getModifiers())+" ");

            //反射获取数据类型
            Class<?> typeClass=field.getType();
            //System.out.println(typeClass);
            //System.out.println(typeClass.getName());
            System.out.print(typeClass.getSimpleName()+" ");//获取类的简称

            System.out.println(field.getName());//x y
        }
        System.out.println("=======获取指定字段信息==========");
        //根据属性的名称来获取Field
        try {
            Field xField=c.getDeclaredField("x");

            //对属性进行赋值操作
            //前提 - 通过反射技术来构建Point对象
            Point p= (Point) c.newInstance();

            xField.setAccessible(true);

            //要想对私有的属性进行操作之前，需要设置读属性是可访问的
            xField.set(p,100);

            System.out.println(p);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
