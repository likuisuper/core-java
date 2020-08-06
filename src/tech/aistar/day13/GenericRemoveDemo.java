package tech.aistar.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * 本类功能:泛型的擦除
 *
 * 1.泛型仅仅在编译期间有效(JVM并不知道泛型的存在)因为泛型在编译阶段就已经被处理成普通的类和方法
 * 2.泛型在运行期间将会被擦除
 * 3.因此泛型没有多态
 *
 * @author cxylk
 * @date 2020/8/6 16:44
 */
public class GenericRemoveDemo {
    public static void main(String[] args) {
        List<Integer> list01=new ArrayList<>();
        List<String> list02=new ArrayList<>();

        //获取运行期间的类型...
        //获取类的class实例

        //1.泛型在运行期间将会被擦除(这里的擦除是指泛型的类型，即尖括号里)
        //编译期间一个只能放Integer类型数据,一个只能放String类型的数据
        //但是在编译完成后都被编译器擦除成了ArrayList
        System.out.println(list01.getClass());//class java.util.ArrayList
        System.out.println(list02.getClass());//class java.util.ArrayList

        //2.泛型没有多态

        //Number n=new Integer(10);//ok
        // m=new Long(10);//ok

        //编译不通过
        //List<Number> list03=new ArrayList<>(Integer);
    }
}
