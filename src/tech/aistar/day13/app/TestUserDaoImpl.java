package tech.aistar.day13.app;

import tech.aistar.day07.User;
import tech.aistar.day10.homework01.Book;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/7 18:50
 */
public class TestUserDaoImpl {
    public static void main(String[] args) {
        UserDaoImpl userDao=new UserDaoImpl();

        User user=new User();
        user.setUsername("admin");

        userDao.save(user);

        BookDaoImpl bookDao=new BookDaoImpl();

        Book book=new Book();

        book.setBookName("西游记");

        bookDao.save(book);

        System.out.println("======");

        IUserDao userDao1=new UserDaoImpl();
        userDao1.save(user);
    }
}
