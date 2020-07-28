package tech.aistar.day07;

/**
 * 本类功能:构造方法的使用
 *
 * @author cxylk
 * @date 2020/7/28 21:08
 */
public class UserConstructorTest {
    public static void main(String[] args) {
        User u1=new User();

        u1.setId(10);
        u1.setId(20);
        System.out.println(u1.getId());

        //user(栈) -> new User(10);[堆]
        User user=new User(10);//赋值的机会只有一次，如果想要进行多次赋值可以使用setter方法

        user.setId(100);

        //又在堆里面新开辟了一块空间了，然后进行对象的初始化，然后将栈里面的引用
        //user重新指向了第二次创建出来的对象
        //这个时候,第20行[第一次创建出来的对象已经没有任何引用指向了],
        //第一个创建出来的对象已经变成了垃圾对象[没有任何引用指向的对象]
        //垃圾对象被垃圾回收机制GC进行回收 - 目的:释放内存
        //user=new User(20);

        System.out.println(user.getId());

        System.out.println("=========");

        User u2=new User(1,"习大大",null,null);

        System.out.println(u2.getUsername());

        System.out.println("====this关键字作用======");

        User u3=new User(100,"james","123");

        System.out.println(u3.getId());
    }
}
