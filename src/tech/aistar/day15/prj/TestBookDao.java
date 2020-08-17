package tech.aistar.day15.prj;

import tech.aistar.day15.io.Book;
import tech.aistar.day15.prj.impl.BookDaoImpl;
import tech.aistar.day15.prj.impl.BookMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/16 14:41
 */
public class TestBookDao {
    public static void main(String[] args) {
        IBookDao bookDao=new BookMapper();
        Book b1=new Book(1,"1001","java");
        Book b2=new Book(2,"1002","python");

//        List<Book> books=new ArrayList<>();
//        books.add(b1);
//        books.add(b2);
//
//        //满足给定条件删除
//        books.removeIf((b)->{
//            return b.getId()==2;
//        });
//
//        books.forEach(e-> System.out.println(e));

        //bookDao.save(b1);
        bookDao.save(b2);

        //bookDao.delById(2);

        List<Book> books=bookDao.findAll();
        if(null!=books&&books.size()>0){
            books.forEach((e)->{
                System.out.println(e);
            });
        }

    }
}
