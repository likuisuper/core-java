package tech.aistar.day17.my;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/24 12:44
 */
public class MainText {
    public static void main(String[] args) {
        //Class<?> clazz=Student.class;
        try {
            Class<?> clazz=Class.forName("tech.aistar.day17.my.Student");

            //获取main方法
            Method method=clazz.getMethod("main",String[].class);
            method.invoke(null, (Object) new String[]{"1","2","3"});
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

