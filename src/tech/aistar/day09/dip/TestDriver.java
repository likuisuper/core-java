package tech.aistar.day09.dip;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/29 18:22
 */
public class TestDriver {
    public static void main(String[] args) {
        Driver driver=new Driver();

//        AoDi aoDi=new AoDi();
//
//        BaoMa baoMa=new BaoMa();
//
//        driver.driverAoDiRun(aoDi);
//        driver.driverBaoMa(baoMa);

        //突然需求更改了，或者扩展了，则要去Driver类中添加方法

        CarSup c1=new AoDi();

        CarSup c2=new BaoMa();


        //调用方法的时候,可以传入这个父类的任何一个子类(多态)
        driver.driverCar(c1);
        driver.driverCar(c2);


        //现在增加一个保时捷类

        CarSup c3=new BaoShiJie();

        driver.driverCar(c3);
    }
}
