package tech.aistar.day03;

/**
 * 本类功能:
 *
 * @Author: cxylk
 * @Date: 2020/7/19 16:36
 */
public class User {
    //非静态成员
    public int id=1;

    //静态成员 - 初始化了一次
    public static int guid=100;

    //构造方法
    public User(){
        System.out.println("User...");
        //id=++id;
        id=++guid;
    }

    public static void main(String[] args) {
        User u1=new User();
        //因为每创建一次对象，id就被初始化一次
        //System.out.println(u1.id);//2

        //guid是静态变量，只被初始化一次，也就是说
        //多个对象共用一个静态变量
        System.out.println(u1.id);//101

        User u2=new User();
        //System.out.println(u2.id);//2
        System.out.println(u2.id);//102

        User u3=new User();
        //System.out.println(u3.id);//2
        System.out.println(u3.id);//103
    }
}
