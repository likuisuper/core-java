package tech.aistar.day08.principles.dp.version02;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/29 15:42
 */
public class TestMiddler {
    public static void main(String[] args) {
        Person person=new Person();

        Middler middler=new Middler();

        //中介找房子
        House house=new House();

        middler.setHouse(house);

        //人找中介
        person.setMiddler(middler);

        person.buy("别墅");
    }
}
