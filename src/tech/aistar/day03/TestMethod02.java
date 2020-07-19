package tech.aistar.day03;

/**
 * 本类功能:
 *
 * @Author cxylk
 * @Date 2020/7/19 13:00
 */
public class TestMethod02 {
    public static void main(String[] args) {
        //1.创建对象
        TestMethod02 t1=new TestMethod02();
        t1.test02();

        System.out.println(t1);
    }

    public void test01(){
        System.out.println("test01...");
    }

    public void test02(){
        //非静态方法想要调用非静态方法，对象实现
        TestMethod02 t2=new TestMethod02();
        //t2.test01();

        //结论：前提：在同一个类中
        //非静态方法中是可以直接去调用本类中另外一个非静态方法的

        //本质是省略了调用了关键字this
        //test01();
        //this代表的就是当前对象（调用test02这个方法的对象）
        //this.test01()

        test01();
        //System.out.println(this);这个this就是t1

        System.out.println("test02...");

        test03();//不能写成this.test03(),会报错
    }

    public static  void test03(){
        //test01();error,因为此时还不存在该方法
        System.out.println("test03..");
    }
}
