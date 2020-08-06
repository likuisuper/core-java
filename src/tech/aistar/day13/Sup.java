package tech.aistar.day13;

import tech.aistar.day10.homework01.Book;

/**
 * 本类功能:泛型类派生出来的子类
 *
 * @author cxylk
 * @date 2020/8/6 15:22
 */
public abstract class Sup<T> {
    public abstract T get(T t);
}

//**子类不明确泛型类的类型参数变量**
class Sub<T> extends Sup<T>{

    @Override
    public T get(T t) {
        return t;
    }
}

//**子类明确泛型类的类型参数变量**
class Sub2<Book> extends Sup<Book>{

    @Override
    public Book get(Book book) {
        return book;
    }
}

class TestSup{
    public static void main(String[] args) {
        //1.子类没有明确泛型的类型参数变量
        Sup<String> sup=new Sub<>();
        String result=sup.get("ok");
        System.out.println(result);

        //2.子类明确泛型类的类型参数变量
        Sup<Book> sup1=new Sub<>();
        System.out.println(sup1.get(new Book()));
    }
}