package tech.aistar.day11;

import tech.aistar.day08.relation.extend.Animal;
import tech.aistar.day08.relation.extend.Cat;

/**
 * 本类功能:获取类的实例
 *
 * 一个类无论被实例化多少次,它在内存中的clas实例永远只有1个
 *
 * @author cxylk
 * @date 2020/8/4 10:35
 */
public class ClassDemo {
    public static void main(String[] args) {
        Book b1=new Book();
        Book b2=new Book();

        Class<?> c=b1.getClass();
        //Class实例是用来描述类的类
        //类有什么东西是可以被描述的???
        //比如类的名称

        String name=c.getName();
        String simpleName=c.getSimpleName();
        System.out.println(name);//tech.aistar.day11.Book
        System.out.println(simpleName);//Book

        Class<?> c2=b2.getClass();//对象.getClass();

        System.out.println(c);//class tech.aistar.day11.Book
        System.out.println(c2);//class tech.aistar.day11.Book

        System.out.println(c==c2);//true

        //直接通过类名.class
        Class<?> c3=Book.class;
        System.out.println(c3);//class tech.aistar.day11.Book

        try {
            Class<?> c4=Class.forName("tech.aistar.day11.Book");
            System.out.println(c4);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //4.基本数据类型.class
        System.out.println(int.class);//int

        Animal cat=new Cat();

        //结论：Class实例 - 对象的运行时类型
        System.out.println(cat.getClass());//class tech.aistar.day08.relation.extend.Cat
    }
}
