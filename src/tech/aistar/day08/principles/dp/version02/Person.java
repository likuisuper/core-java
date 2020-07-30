package tech.aistar.day08.principles.dp.version02;

/**
 * 本类功能:人 直接 和 房源 产生交互
 *
 * 不符合 迪米特原则 - 最少知道原则
 *
 *
 * @author cxylk
 * @date 2020/7/29 15:42
 */
public class Person {
    //1.人和房子之间是符合"迪米特"原则的
    // 人 只和 直接的朋友(中介) 进行交互了

    //更新房源的话,和Person模块是没有关系的
    //House模块和Person模块之间是解耦合了
    private Middler middler;

    public void setMiddler(Middler middler){
        this.middler=middler;
    }

    public void buy(String name){
        //通过中介购买
        middler.find(name);
    }
}
