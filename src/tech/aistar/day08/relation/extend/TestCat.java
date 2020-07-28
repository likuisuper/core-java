package tech.aistar.day08.relation.extend;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/28 15:20
 */
public class TestCat {
    public static void main(String[] args) {
        //创建一个猫的
        Cat cat=new Cat("咪咪",7,100.0d);

        System.out.println(cat.getName());
        System.out.println(cat.getAge());
        System.out.println(cat.getCute());

        cat.sleeping();

        cat.catchMouse();

        cat.spark();
    }
}
