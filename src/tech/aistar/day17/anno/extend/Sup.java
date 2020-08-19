package tech.aistar.day17.anno.extend;

import java.lang.reflect.Method;

/**
 * 本类功能:
 * 1.子类可以继承父类类型上添加的注解
 * 2.子类不能够继承父类方法上添加的注解 - 子类重写了父类的方法
 *
 * @author cxylk
 * @date 2020/8/19 19:58
 */
@Select("select * from user")
public class Sup {
    @Select("select * from test")
    public void test(){}

}

class Sub extends Sup{
    //重写父类中的方法

    @Override
    public void test() {

    }
}

class TestSup{
    public static void main(String[] args) {
        //1.获取子类的class实例
        Class<?> c=Sub.class;

        //判断子类Sub上是否添加了注解
        if (c.isAnnotationPresent(Select.class)) {

            System.out.println("类上面注解被继承");
        }else {
            System.out.println("没有");
        }

        //2.获取Method对象
        try {
            Method m=c.getDeclaredMethod("test");
            if(m.isAnnotationPresent(Select.class)){
                System.out.println("方法上的注解被子类继承");
            }else{
                System.out.println("方法上的注解不能被子类继承");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
