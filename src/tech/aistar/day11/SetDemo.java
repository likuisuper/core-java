package tech.aistar.day11;

import java.util.HashSet;
import java.util.Set;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/3 19:08
 */
public class SetDemo {
    public static void main(String[] args) {
        //无序不可重复
        Set<Book> sets=new HashSet<>();

        Book b1 = new Book(1,"1001","java");
        Book b2 = new Book(2,"1002","java");
        Book b3 = new Book(3,"1003","java");
        Book b4 = new Book(1,"1004","java");

        sets.add(b1);
        sets.add(b2);
        sets.add(b3);
        sets.add(b4);

        System.out.println(sets.size());

    }
}
