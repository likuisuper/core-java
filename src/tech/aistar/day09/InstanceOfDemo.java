package tech.aistar.day09;

import tech.aistar.day08.relation.extend.Animal;
import tech.aistar.day08.relation.extend.Cat;
import tech.aistar.day08.relation.extend.Dog;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/29 20:43
 */
public class InstanceOfDemo {
    public static void main(String[] args) {
        //多态的应用
        Animal dog = new Dog();

        Dog d = new Dog();

        Animal cat = new Cat();

        System.out.println(dog instanceof Dog);//true

        System.out.println(dog instanceof Animal);//true

        System.out.println(d instanceof Animal);//true

        System.out.println(dog instanceof Cat);//false

        System.out.println("=====");
        Animal[] animals = new Animal[2];

        animals[0] = dog;
        animals[1] = cat;

        //animal中既包含狗,又包含猫
        for (Animal animal : animals) {
            //调用Animal类中提供的公共的方法...
            animal.sleeping();

            //继续调用子类中特有的方法..
            //解决方案: 强制类型转换.

            //java.lang.ClassCastException 类型转换失败异常
            //为了避免类型转换失败异常的出现 - 在进行强制类型转换的时候
            //需要先进行类型的判断
            if(animal instanceof Dog) {
                Dog dogs = (Dog) animal;
                dogs.watchDoor();
            }

            if(animal instanceof Cat) {
                Cat cats = (Cat) animal;
                cats.catchMouse();
            }

            System.out.println("=====");
        }
    }
}
