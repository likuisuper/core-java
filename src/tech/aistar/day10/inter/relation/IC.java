package tech.aistar.day10.inter.relation;

/**
 * 本类功能:接口是支持多重继承
 * 一个接口可以拥有多个直接的父类接口
 *
 * @author cxylk
 * @date 2020/7/31 18:02
 */
public interface IC extends IA,IB{
    //子接口中也是可以扩展新的功能的
    void update();
}
