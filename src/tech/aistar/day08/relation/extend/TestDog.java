package tech.aistar.day08.relation.extend;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/28 15:34
 */
public class TestDog {
    public static void main(String[] args) {
        //创建一个Dog对象
        //先有对象，再有构造方法

       //Animal空参构造被调用了...
        //Dog()空参构造被调用了...
        Dog dog=new Dog();

        //设置独有的属性
        dog.setLoyalty(100.0d);

        //子类可以使用父类中已经提供好的非私有的成员
        dog.setName("哮天犬");
        dog.setAge(7);

        //此时调用的是父类中重写的toString方法
        System.out.println(dog.toString());

        //子类可以调用父类中提供好的非私有方法
        dog.sleeping();

        //子类可以调用自己独有的方法
        dog.watchDoor();

        System.out.println("==========");

        //调用重写的方法
        dog.spark();
    }
}
