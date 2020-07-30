package tech.aistar.day08.principles;

import tech.aistar.day08.relation.extend.Animal;
import tech.aistar.day08.relation.extend.Cat;
import tech.aistar.day08.relation.extend.Dog;

/**
 * 本类功能:instanceof关键字
 *
 * @author cxylk
 * @date 2020/7/29 20:43
 */
public class InstanceOfDemo {
    public static void main(String[] args) {
        //多态的应用
        Animal dog=new Dog();

        Dog d=new Dog();

        Animal cat=new Cat();

        System.out.println();

        //instanceof 判断类型的归属的
        //左边的对象是否是它右边的类的实例
        System.out.println(dog instanceof Dog);//true

        System.out.println(dog instanceof Animal);//true

        System.out.println(d instanceof Animal);//true

        System.out.println(dog instanceof Cat);//false

        System.out.println("=======");

        Animal[] animals=new Animal[2];

        animals[0]=dog;
        animals[1]=cat;

        for(Animal animal:animals){
            animal.sleeping();

            //java.lang.ClassCastException 类型转换失败异常
//            Dog dogs=(Dog)animal;
//            dogs.watchDoor();

            //为了避免类型转换失败异常的出现 - 在进行强制类型转换的时候
            //需要进行类型的判断
            if(animal instanceof Dog){
                Dog dogs=(Dog)animal;
                dogs.watchDoor();
            }

            if(animal instanceof Cat){
                Cat cats=new Cat();
                cats.catchMouse();
            }

            System.out.println("========");
        }
    }
}
