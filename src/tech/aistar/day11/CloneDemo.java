package tech.aistar.day11;

/**
 * 本类功能：拷贝
 *
 * 1.原型模式
 *
 * @author cxylk
 * @date 2020/8/4 9:21
 */
public class CloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book b1=new Book(1,"1001","java");

        BookInfo info=new BookInfo(1,"这是一本好书");
        b1.setInfo(info);
        System.out.println(b1.getInfo());

        //调用clone方法之前，要重写clone(java.lang.Object中提供的clone方法 )浅克隆
        //并且Book中要实现Cloneable接口
        try {
            Book b2 = (Book) b1.clone();
            //System.out.println(b2);

            //特点：修改原对象b1,看是否对拷贝出来的副本对象b2造成影响
            //修改原对象的基本数据类型的时候,没有对副本造成影响
            //基本数据类型和String直接拷贝了一份给副本
            b1.setId(100);
            b1.setIsbn("1002");
            //System.out.println(b2);//值没有改变

            b1.getInfo().setRemark("这是坏书");
            System.out.println(b2);
            System.out.println(b2.getInfo());
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
