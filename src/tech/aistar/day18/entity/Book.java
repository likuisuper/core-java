package tech.aistar.day18.entity;

import java.io.Serializable;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/19 20:08
 */
public class Book implements Serializable {
    private Integer id;

    private String name;

    private String author;

    private double price;

    private BookInfo bookInfo;

    public Book() {
    }

    public Book(Integer id, String name, String author, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", price=").append(price);
        sb.append(", bookInfo=").append(bookInfo);
        sb.append('}');
        return sb.toString();
    }
}
