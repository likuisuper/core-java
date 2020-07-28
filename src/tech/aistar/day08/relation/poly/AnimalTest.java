package tech.aistar.day08.relation.poly;

import tech.aistar.day08.relation.extend.Animal;
import tech.aistar.day08.relation.extend.Cat;
import tech.aistar.day08.relation.extend.Dog;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/28 18:36
 */
public class AnimalTest {
    public static void main(String[] args) {
        //多态的应用
        //对象的编译时类型写成父类,对象的运行时类型写成子类
        Animal dog=new Dog();//ok
        //编译时类型决定了对象的访问能力
        //对象只能在访问到编译时类型中提供的非私有的成员

        //运行时类型决定了对象的行为能力
        //子类一旦重写了父类中的方法，那么在运行时调用的就是子类重写过后的
        dog.spark();

        //多态:同一操作作用于不同的对象，可以有不同的解释,
        //产生不同的执行结果.在运行时,可以通过指向基类的指针,
        //来调用实现派生类中的方法

        Animal cat=new Cat();
        cat.spark();
    }
}
