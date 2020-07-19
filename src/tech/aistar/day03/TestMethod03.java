package tech.aistar.day03;

/**
 * 本类功能:方法之间的调用
 *
 * @Author: cxylk
 * @Date: 2020/7/19 15:44
 */
public class TestMethod03 {
    static int id=100;

    public static void main(String[] args) {
        TestMethod03 t=new TestMethod03();
        t.test02();
        //System.out.println(t);

        //静态方法中是可以直接调用静态方法的
        test03();
    }

    public void test01(){
        System.out.println("test01");
        //this.test02();
    }

    /**
     * test01能够被成功调用的前提是先调用test02,而调用test02的前提是先创建一个对象
     *
     * 所以当程序如果能顺利执行到test01,内存中肯定已经存在所需要的this对象
     */
    public void test02(){
        //这个this的值和main方法中t的值是一样的
        //因为调用test02方法的是t
        //System.out.println(this);

        //对象.成员
        TestMethod03 t=new TestMethod03();
        t.test01();

        //结论：前提：在同一个类中
        //前提：非静态方法中是允许直接调用非静态方法的 - 省略对象
        //test01();

        //简写的代码背后是省略的this关键字

        test01();

        //this代表的是当前对象(调用当前方法test02这个方法的对象)

        System.out.println("test02...");

        //非静态方法中是可以直接调用静态方法的

        test03();//test03早就已经在内存躺着了
    }

    public static void test03(){
        //静态方法中如何调用非静态方法？-对象.方法
        TestMethod03 t=new TestMethod03();
        t.test01();
        System.out.println("test03");
    }

    public void test04(){
        //static int i=10;//static不允许在这
        System.out.println(id);
    }

    public static void test05(){
        //static int i=10;//error,因为静态变量在静态方法之前

        System.out.println(id);

    }
}
