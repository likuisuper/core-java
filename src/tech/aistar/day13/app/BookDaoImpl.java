package tech.aistar.day13.app;

import tech.aistar.day10.homework01.Book;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/7 18:46
 */
public class BookDaoImpl extends BaseDaoImpl<Book> implements IBookDao {
    @Override
    public void finBook() {
        System.out.println("book....");
    }
}
