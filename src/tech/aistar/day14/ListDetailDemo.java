package tech.aistar.day14;

import tech.aistar.day10.homework01.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 本类功能:集合的细节操作
 * 1.如果修改
 *
 * @author cxylk
 * @date 2020/8/11 23:02
 */
public class ListDetailDemo {
    public static void main(String[] args) {
        List<Book> lists=new ArrayList<>();
        lists.add(new Book(1,"1001","java"));
        lists.add(new Book(2,"1002","python"));
        lists.add(new Book(3,"1003","web"));

        //定义一个集合的时候,可以通过另外一个集合
        List<Book> books=new ArrayList<>(lists);

        //注意点
        //随机打乱一个集合
        Collections.shuffle(lists);

        //反转
        Collections.reverse(lists);

        //无论是打乱还是反转都没有对books造成影响
        books.forEach(e-> System.out.println(e));

        //有影响
//        lists.get(0).setBookName("success");
//
//        books.forEach(e-> System.out.println(e));
    }
}
