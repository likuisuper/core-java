package tech.aistar.day17.my;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 本类功能:泛型用在编译期，编译过后泛型擦除
 * 所以是可以通过反射越过泛型检查的
 *
 * @author cxylk
 * @date 2020/8/24 13:02
 */
public class Type {
    public static void main(String[] args) {
//        ArrayList<String> list=new ArrayList<>();
//        list.add("aaa");
//        list.add("bbb");
//
//        //list.add(100);用了泛型这里就会报错
//        Class<?> listClass=list.getClass();
//        //获取add方法
//        try {
//            Method m=listClass.getMethod("add",Object.class);
//            //调用add方法
//            m.invoke(list,100);
//
//            for (Object s : list) {
//                System.out.println(s);
//            }
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

        List<Integer> list=new ArrayList<>();

        list.add(2);
        list.add(5);

        Class<?> listClass=list.getClass();

        try {
            Method m=listClass.getMethod("add",Object.class);

            m.invoke(list,"java");

            for (Object integer : list) {
                System.out.println(integer);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
