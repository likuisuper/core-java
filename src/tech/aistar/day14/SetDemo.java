package tech.aistar.day14;

import tech.aistar.day10.homework01.Book;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/10 16:27
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<Book> sets=new HashSet<>();//无序不可重复
        Book b1=new Book(1,"1001","java");
        Book b2=new Book(3,"1002","python");
        Book b3=new Book(3,"1003","java");

        sets.add(b1);
        sets.add(b2);
        sets.add(b3);

//        sets.forEach(new Consumer<Book>() {
//            @Override
//            public void accept(Book book) {
//                System.out.println(book);
//            }
//        });

        sets.forEach(b -> System.out.println(b));

        sets.forEach(System.out::println);
    }
}
