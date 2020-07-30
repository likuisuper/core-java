package tech.aistar.day09;

import tech.aistar.day08.relation.extend.Animal;
import tech.aistar.day08.relation.extend.Cat;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/29 20:43
 */
public class AnimalFactory {
    //面向父类编程3 - 方法的返回类型写成父类,方法的返回值可以是这个父类的任何一个子类对象.
    public static Animal getInstance(){
        return new Cat();
    }
}

class TestF{
    public static void main(String[] args) {

        Animal animal = AnimalFactory.getInstance();
    }
}
