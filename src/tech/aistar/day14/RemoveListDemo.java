package tech.aistar.day14;

import tech.aistar.day10.homework01.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 本类功能:集合的删除操作
 *
 * @author cxylk
 * @date 2020/8/10 16:33
 */
public class RemoveListDemo {
    public static void main(String[] args) {
//        List<Book> books=new ArrayList<>();
//        Book b1=new Book(1,"1001","java");
//        Book b2=new Book(2,"1002","python");
//        Book b3=new Book(3,"1003","java");
//        Book b4=new Book(4,"1004","java");
//        Book b5=new Book(5,"1005","java");
//
//        books.add(b1);
//        books.add(b2);
//        books.add(b3);
//        books.add(b4);
//        books.add(b5);
//
//        //safeDel(books,"java");//ConcurrentModificationException
//
//        safeDel(books,"java");
//
//        for(Book book:books){
//            System.out.println(book);
//        }

        //删除测试
        ArrayList<String> list=new ArrayList<>();
        list.add("java");
        list.add("aaa");
        list.add("java");
        list.add("java");
        list.add("java");
        list.add("bbb");

        //list.remove("java");//只能删除一个java

//        for (int i = 0; i < list.size(); i++) {
//            if("java".equals(list.get(i)))
//                //当删除一个元素时，所有的后续元素会向左移动，导致原来的索引发生变化
//                //所以会出现漏删的情况
//                list.remove(i);
//        }
        
        //正确的删法，倒着删
        for (int i = list.size()-1; i >= 0; i--) {
            if("java".equals(list.get(i)))
                list.remove(i);
        }

        list.forEach((e)->{
            System.out.println(e);
        });
    }

    /**
     * 安全的删除方式 - 普通的for循环
     * 根据图书名称进行删除
     * @param books
     * @param bookName
     */
    private static void removeByBookName(List<Book> books,String bookName){
//        for (int i = 0; i < books.size(); i++) {
//            //boolean remove(int index);//根据下标进行删除
//            //boolean remove(E e)
//            if(books.get(i).getBookName().equals(bookName)){
//                books.remove(i);//涉及到下标的移动
//                i--;
//            }
//        }

        for (int i = books.size()-1; i >=0; i--) {
            if(books.get(i).getBookName().equals(bookName))
                books.remove(i);
        }
    }

    /**
     * 非安全删除
     * 增强for循环是一个只读的循环
     * 禁止在遍历集合的同时，再去进行删除操作
     * 如果执行了这个操作，它会抛出一个并发修改的异常
     * @param list
     * @param bookName
     */
    private static void unSafeDel(List<Book> list,String bookName){
        for(Book book:list){
            if(book.getBookName().equals(bookName)){
                list.remove(book);//直接删除对象
            }
        }
    }

    private static void safeDel(List<Book> list,String bookName){
//        Iterator<Book> iter=list.iterator();
//        while(iter.hasNext()){
//            Book b=iter.next();
//            if(b.getBookName().equals(bookName)){
//                list.remove(b);//并发修改异常...
//            }
//        }

        Iterator<Book> iter=list.iterator();

        while(iter.hasNext()){
            Book b=iter.next();

            if(b.getBookName().equals(bookName)){
                //list.remove(b);//并发修改异常

                //删除正在被迭代到的对象
                iter.remove();
            }
        }
    }
}
