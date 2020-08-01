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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    @Override
    public void add(Book b) {
        IBookBiz bookBiz = new IBookBiz() {
            @Override
            public void add(Book b) {
                books=Arrays.copyOf(books,books.length+1);
                books[books.length-1]=b;
            }

            @Override
            public void deleteByName(String name) {

            }

            @Override
            public void outputAllBooks() {
                for (Book book : books) {
                    System.out.println(book);
                }
            }
        };






























































        bookBiz.outputAllBooks();

    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public void outputAllBooks() {

    }
}

