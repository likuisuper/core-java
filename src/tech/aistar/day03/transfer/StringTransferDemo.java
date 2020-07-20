package tech.aistar.day03.transfer;

/**
 * 本类功能:java.lang.String字符串虽然是一个对象类型，但是在进行方法参数传递的时候，具有"值传递"的特性
 *
 * 还有一个对象java.util.Data类型
 *
 * @author cxylk
 * @date 2020/7/20 18:29
 */
public class StringTransferDemo {
    public static void main(String[] args) {
        String s="good";

        change(s);

        System.out.println("s->"+s);//good,内容不变，因为string不可变
    }

    private static void change(String s) {
        s+=" ok";
        System.out.println("s:"+s);//good ok
    }
}
