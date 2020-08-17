package tech.aistar.day15.prj.impl;

import tech.aistar.day15.io.Book;
import tech.aistar.day15.prj.IBookDao;
import tech.aistar.day15.prj.ObjectDaoUtil;

import java.util.List;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/16 15:37
 */
public class BookMapper implements IBookDao {
    //模拟数据库 - 文件
    private static final String PATH="src/tech/aistar/day15/prj/db/books.dat";

    @Override
    public List<Book> findAll() {
        return ObjectDaoUtil.findAll(PATH);
    }

    @Override
    public void delById(int id) {

    }

    @Override
    public void save(Book b) {
        ObjectDaoUtil.save(b,PATH);
    }
}
