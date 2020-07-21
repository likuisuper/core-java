package tech.aistar.day03;

/**
 * 本类功能:重载的方法
 * 前提：重载的方法肯定是出现在同一个类中
 * 1.重载的方法的名臣肯定是一致的
 * 2.重载的方法的参数列表肯定是不一样的
 * 2-1.参数列表的个数不一样
 * 2-2.个数一样的时候，参数类型肯定要不一样
 * 3.重载的方法的返回类型可以不一样
 *
 * @author cxylk
 * @date 2020/7/20 20:23
 */
public class LoadDemo {
    public static void main(String[] args) {
        add(10);

        System.out.println("ok");
    }

    public static void add() {
        System.out.println("add");
    }

    public static void add(int i) {
        System.out.println("i:"+i);
    }

    public static void add(int i,String j){
        System.out.println("i:"+i+",j"+j);
    }

    public static double add(double d){
        System.out.println("double:"+d);
        return d;
    }
}


