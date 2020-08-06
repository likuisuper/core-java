package tech.aistar.day13;

import tech.aistar.day10.homework01.Book;

import java.util.HashMap;
import java.util.Map;

/**
 * 本类功能:泛型 K,V
 *
 * @author cxylk
 * @date 2020/8/6 19:05
 */
public class EntryDemo<K,V> {
    private K key;

    private V value;

    public EntryDemo() {
    }

    public EntryDemo(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void put(K key,V value){
        setKey(key);
        setValue(value);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EntryDemo{");
        sb.append("key=").append(key);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}

class TestKV{
    public static void main(String[] args) {
        EntryDemo<Integer, Book> books=new EntryDemo<>();
        books.put(1,new Book(1,"1001","java"));
        books.put(2,new Book(2,"1001","java"));

        System.out.println(books);

        //map集合
        Map<Integer,String> maps=new HashMap<>();
        maps.put(10,"1001");
        maps.put(20,"1001");
        System.out.println(maps);
    }
}
