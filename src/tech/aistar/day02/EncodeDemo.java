package tech.aistar.day02;

/**
 * 本类用来演示：内码和外码
 *
 * java底层的内码unicode统一使用2个字节处理
 *
 * 乱码产生的过程：
 *
 * UTF-8 - X1 X2 X3  Y1 Y2 Y3  U1 U2 U3
 *
 * GBK-> X1X2 X3Y1 Y2Y3 U1U2 U3
 *
 * @Author 箜絔lk
 * @Date 2020/7/17 18:36
 */
public class EncodeDemo {
    public static void main(String[] args) {
        String name="你好世界";
        //获取字符串的字节数组
        byte[] buf=name.getBytes();

        //.java以及.class文件的编码都是utf-8,一个汉字占3个字节，一个数字，一个字母，一个符号占1个字节

        //gbk.一个汉字占2个字节，数字，字母，符号仍然是占1个字节
        System.out.println(buf.length);
    }
}
