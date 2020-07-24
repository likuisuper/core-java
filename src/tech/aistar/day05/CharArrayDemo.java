package tech.aistar.day05;

/**
 * 本类功能:char类型数组
 *
 * @author cxylk
 * @date 2020/7/24 20:22
 */
public class CharArrayDemo {
    public static void main(String[] args) {
        int[] arr={1,3,3};
        System.out.println(arr);//内存地址 -[I@14ae5a5
        //因为println中调用了String.valueOf方法(返回String类型)，而valueOf方法中又调用了obj.toString方法
        //在toString方法中，return getClass().getName() + "@" + Integer.toHexString(hashCode());
        System.out.println(arr.getClass().getName()+"@"+Integer.toHexString(arr.hashCode()));

        char[] c={'a','b','c'};
        System.out.println(c);//直接打印出abc
    }
}
