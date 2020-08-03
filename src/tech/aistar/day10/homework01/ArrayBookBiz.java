package tech.aistar.day10.homework01;


import java.util.Arrays;

/**
 * 本类功能:数组图书管理业务实现类
 *
 * @author cxylk
 * @date 2020/7/31 20:07
 */
public class ArrayBookBiz implements IBookBiz {
    private static final int CAPACITY = 5;

    //有效图书数量
    private int count;

    private Book[] books = new Book[CAPACITY];


    @Override
    public void add(Book b) {

    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void outputAllBooks() {

    }
}

