package tech.aistar.day14;

import tech.aistar.day10.homework01.Book;

import java.util.LinkedList;

/**
 * 本类功能:LinkedList - 适合解决队列和栈的业务
 *
 * @author cxylk
 * @date 2020/8/10 16:56
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Book> list=new LinkedList<>();

        Book b1=new Book(1,"1001","java");
        Book b2=new Book(2,"1002","python");
        Book b3=new Book(3,"1003","web");

        Book b4=new Book(4,"1004","web");
        Book b5=new Book(5,"1005","web");
        Book b6=new Book(6,"1006","web");
        Book b7=new Book(7,"1007","web");

        //默认的是集合的尾部进行插入
        list.add(b1);
        list.add(b2);
        list.add(b3);

        //补充相关的add方法
        //在集合的末尾进行添加
        list.addLast(b4);//返回类型是void

        list.addFirst(b5);

        //压栈的方法 - 压入栈顶
        //push方法和pop方法通常是用来模拟栈 - 先进后出
        list.push(b6);

        //弹出栈顶元素 - 删除并且返回栈顶的元素
        System.out.println(list.pop());

        //关于删除的
        //删除并且返回头节点
        System.out.println(list.removeFirst());

        //删除并且返回尾结点
        System.out.println(list.removeLast());

        //相当于getFirst() - 获取元素但是并没有移除
        System.out.println(list.element());

        list.offerFirst(b7);//相当于addFirst - 有返回类型的boolean

        System.out.println("==========");

        list.forEach(e-> System.out.println(e));


        System.out.println("=====分割线======");

        //每次获取集合的size() - 方法性能是很低的
        System.out.println(list.size());

        //获取头节点
        System.out.println(list.getFirst());

        //栈列 - 先进后出


        //队列 - 先进先出
        //add和getFirst

        //1. 删除方法
        //1-1. 删除头 - 获取头信息但是不删除的,仅仅是获取头信息的
        //1-2. 删除尾 - removeLast

        //2. 添加
        //1-1. 添加到头部 - addFirst,offerFirst,push
        //1-2. 添加到尾部 - add,addLast,offerLast

        //删除并且返回刚刚删除的元素
        //LinkedList集合的增删效率比较高,只会涉及到相邻节点的移动
        System.out.println(list.remove(1));
    }
}
