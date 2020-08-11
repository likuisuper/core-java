package tech.aistar.day14.homework;

import tech.aistar.day10.homework01.Book;

import java.util.HashMap;
import java.util.Map;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/11 22:54
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,10);
        map.put(2,20);
        map.put(3,30);

        Integer count=map.get(2);
        count+=20;

        //System.out.println(map.get(2));//还是20

        map.put(2,count);
        System.out.println(map.get(2));//变成了40

        Map<Integer,Book> maps=new HashMap<>();
        maps.put(1,new Book(1,"1001","java"));

        Book b=maps.get(1);
        b.setBookName("python");

        System.out.println(maps.get(1));//值改变
    }
}
