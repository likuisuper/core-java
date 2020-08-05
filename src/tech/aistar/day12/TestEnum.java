package tech.aistar.day12;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/5 19:38
 */
public class TestEnum {
    public static void main(String[] args) {
        //枚举类型.枚举实例 -> 枚举常量的名称
        System.out.println(EnumDemo.SPRING);


        System.out.println("----");

        //将所有的枚举实例全部获取放到数组中
        EnumDemo[] enumDemos=EnumDemo.values();
        for(EnumDemo e:enumDemos){
            System.out.println(e);//枚举常量的名称,因为重写了toString方法
        }
    }
}
