package tech.aistar.day11;

import java.util.Date;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/3 18:42
 */
public class Book {
    private int id;

    private String isbn;

    private String bookName;

    private double price;

    private String author;

    private Date publishDate;//出版日期

    private BookInfo info;//图书的详细信息

    public Book() {
    }

    public Book(int id, String isbn, String bookName) {
        this.id = id;
        this.isbn = isbn;
        this.bookName = bookName;
    }

    public Book(int id, String isbn, String bookName, double price, String author, Date publishDate, BookInfo info) {
        this.id = id;
        this.isbn = isbn;
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.publishDate = publishDate;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public BookInfo getInfo() {
        return info;
    }

    public void setInfo(BookInfo info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id == book.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
//    @Override
//    public boolean equals(Object obj) {
//        //1.非空性
//        if (null == obj)
//            return false;
//        //2.自反性
//        if (this == obj)
//            return true;
//        //3.类型判断
//        if (obj instanceof Book) {
//            Book b = (Book) obj;
//            //只要两个图书的id是一样的,就认为是同一个对象
//            return this.id == b.getId();
//
//            //id以及isbn同时一致的时候,才认为是同一个对象
//            //return this.id == b.getId() && this.isbn.equals(b.getIsbn()) && this.info.equals(b.info);
//        }
//        return false;
//    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", isbn='").append(isbn).append('\'');
        sb.append(", bookName='").append(bookName).append('\'');
        sb.append(", price=").append(price);
        sb.append(", author='").append(author).append('\'');
        sb.append(", publishDate=").append(publishDate);
        sb.append('}');
        return sb.toString();
    }
}
