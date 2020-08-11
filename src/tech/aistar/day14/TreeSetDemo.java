package tech.aistar.day14;

import tech.aistar.day10.homework01.Book;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 本类功能:传入一个比较器接口对象来定制排序的规则
 *
 * @author cxylk
 * @date 2020/8/11 23:13
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        Book b1=new Book(1,"1001","java",100.0);
        Book b2=new Book(2,"1002","java",300.0);
        Book b3=new Book(3,"1003","java",300.0);
        Book b4=new Book(4,"1004","java",400.0);

        //如果涉及到定制排序,一定要慎用,排序的字段如果有重复的,则拒绝添加
        //一般是使用它来对唯一性的字段来进行排序
        Comparator<Book> c=(o1,o2)->{
            return (int) (o1.getPrice()-o2.getPrice());
        };

        TreeSet<Book> books=new TreeSet<>(c);

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);

        //当要排序的price有重复的时候,b3无法被添加
        books.forEach(e-> System.out.println(e));

    }
}
