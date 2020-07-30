package tech.aistar.day08.principles.dp.version01;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/29 15:12
 */
public class TestHouse {
    public static void main(String[] args) {
        //1.创建一个人的对象
        Person person=new Person();

        //2.创建一个房源的对象
        House house=new House();

        //人买房
        person.setHouse(house);

        person.buy();
    }
}

