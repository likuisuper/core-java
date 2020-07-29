package tech.aistar.day09.dp.version03;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/29 16:55
 */
public class TestMiddler {
    public static void main(String[] args) {
        Person person=new Person();

        //房地产公司实例化一个房源出来
        //HouseSup houseSup=new House();
        HouseSup houseSup=new HouseMaoCaoWu();

        //中介公司实例化一个中介出来
        MiddlerSup middlerSup=new Middler(houseSup);

        //中介找到房源了

        person.setMiddlerSup(middlerSup);

        person.buy("mm");
    }
}
