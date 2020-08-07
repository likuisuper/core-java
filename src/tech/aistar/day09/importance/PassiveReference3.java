package tech.aistar.day09.importance;

/**
 * 本类功能:被动使用类字段演示3
 *
 * @author cxylk
 * @date 2020/8/7 19:41
 */

class ConstClass{
    static{
        System.out.println("ConstClass init");
    }
    public static final String HELLOWORLD="hello word";
}
public class PassiveReference3 {
    public static void main(String[] args) {
        //并不会输出 ConstClass init
        //因为编译阶段已经将此常量的值"hello world"存储到了NotInitialization类的
        //常量池中
        System.out.println(ConstClass.HELLOWORLD);
    }
}
