package tech.aistar.day03.modifier;

/**
 * 本类功能:方法的定义者
 *
 * @author cxylk
 * @date 2020/7/20 12:56
 */
public class Test01 {
    //public - 公开的，公共的 - 该方法对外暴露
    public void test01(){
        System.out.println("test01...");
    }

    //私有方法 - private - 只能在本类 中进行调用
    private void test02(){
        System.out.println("test02...");
    }

    public static void test03(){
        System.out.println("test03...");
    }
}
