package tech.aistar.day10.homework01;


/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/31 20:23
 */
public class TestBook {
    public static void main(String[] args) {
        IBookBiz bookBiz=new ArrayBookBiz();
        Book book1=new Book(1,"完美世界",78);

        Book book2=new Book(2,"遮天",148);

        Book book3=new Book(3,"凡人修仙传",76);

        Book book4=new Book(4,"求魔",57);

        Book book5=new Book(5,"仙逆",120);

        Book book6=new Book(6,"童话",220);

        bookBiz.add(book1);
        bookBiz.add(book2);
        bookBiz.add(book3);
        bookBiz.add(book4);
        bookBiz.add(book5);
        bookBiz.add(book6);


        bookBiz.outputAllBooks();
    }
}
