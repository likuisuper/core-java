package tech.aistar.day15.prj.impl;

import tech.aistar.day10.homework01.Book;
import tech.aistar.day15.prj.IBookDao;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/12 12:52
 */
public class BookDaoImpl implements IBookDao {
    @Override
    public List<Book> findAll() {
        ObjectInputStream in=null;
        //in=new ObjectInputStream(new FileInputStream());
        return null;
    }

    @Override
    public void delById(int id) {

    }

    @Override
    public void save(Book b) {

    }
}
