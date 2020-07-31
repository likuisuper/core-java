package tech.aistar.day10.inter.relation;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/31 17:54
 */
public interface IA {
    //protected int i=1;//protected not allowed here
    //private int i=1;//protected not allowed here
    //public int k=1;//ok

    void add();

    //jdk8.0以后可以定义普通方法，不过要加default关键字
    default void a(){
        System.out.println("a...");
    }
}
