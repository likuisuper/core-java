package tech.aistar.day10.inter.relation;

/**
 * 本类功能:
 * 当一个普通类实现某个接口的时候,那么这个普通类必须要实现这个接口以及
 * 这个接口的父接口的所有抽象方法
 *
 * @author cxylk
 * @date 2020/7/31 18:04
 */
public class Cimpl implements IC{
    @Override
    public void update() {
        System.out.println("c...update...");
    }

    @Override
    public void add() {
        System.out.println("c...add...");
    }

    @Override
    public void find() {
        System.out.println("c...find...");
    }
}

//如果这个类是一个抽象类,那么就不需要强制实现这个IC接口中的所有的抽象方法了
abstract class Cimpl2 implements IC{

}

class Cimpl2Sub extends Cimpl2{

    @Override
    public void update() {

    }

    @Override
    public void add() {

    }

    @Override
    public void find() {

    }
}
