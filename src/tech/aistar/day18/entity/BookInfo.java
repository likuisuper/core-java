package tech.aistar.day18.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/19 20:10
 */
public class BookInfo implements Serializable {
    private String publishHouse;

    private Date publishDate;

    private int pages;

    private String description;

    public BookInfo() {
    }

    public BookInfo(String publishHouse, Date publishDate, int pages, String description) {
        this.publishHouse = publishHouse;
        this.publishDate = publishDate;
        this.pages = pages;
        this.description = description;
    }

    public String getPublishHouse() {
        return publishHouse;
    }

    public void setPublishHouse(String publishHouse) {
        this.publishHouse = publishHouse;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookInfo{");
        sb.append("publishHouse='").append(publishHouse).append('\'');
        sb.append(", publishDate=").append(publishDate);
        sb.append(", pages=").append(pages);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
