package tech.aistar.day09.dip;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/29 18:21
 */
public class Driver {

    //司机类中依赖具体的某个汽车

    //司机已经和奥迪类产生了高耦合
    //司机类是依赖于各个汽车类

//    public void driverAoDiRun(AoDi aoDi){
//        aoDi.run();
//    }
//
//    public void driverBaoMa(BaoMa baoMa){
//        baoMa.run();
//    }

    //当掌握了一项新的技能的时候，需要修改司机类

    //说明司机类和各个汽车类产生了强耦合的关系
    //不符合 "开闭原则", "高内聚，低耦合"

    //根据依赖倒置原则，依赖于抽象而不依赖于具体

    //方法的参数类型可以是父类
//    public void driverCar(CarSup carSup){
//        carSup.run();
//    }

    public void driverCar(CarSup carSup){
        carSup.run();
    }
}
