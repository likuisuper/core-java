package tech.aistar.day10.all;

/**
 * 本类功能:演员模板类
 *
 * @author cxylk
 * @date 2020/7/31 16:21
 */
public abstract class PlayerTemplate {
    public void test01(){
        System.out.println("开幕");
    }

    public void test02(Player player){
        System.out.println(player.getName()+"演员登场");
    }

    public void test03(){
        //每个子类的实现都不一样,延迟到子类中去实现
        play();
    }

    public abstract void play();

    public void test04(){
        System.out.println("落幕退场");
    }


    //提供一个执行固定的业务流程的方法
    public final void start(Player player){
        test01();

        test02(player);

        test03();

        test04();
    }
}
