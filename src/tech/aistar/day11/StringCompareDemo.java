package tech.aistar.day11;

/**
 * 本类功能:字符串的比较
 *
 * @author cxylk
 * @date 2020/7/31 13:35
 */
public class StringCompareDemo {
    public static void main(String[] args) {
        String s1="a";
        String s3=s1+"b";//不在串池中

        String s4="ab";//串池中
        System.out.println(s4==s3);//false

        String s5="a"+"b";//由于"a"和"b"都是精确的字符串常量,拼接的结果必然存在于常量池中
        System.out.println(s4==s5);//true

        //s6默认指向的是堆空间的字符串对象
        String s6=new String("ab");
        System.out.println(s4==s6);//false

        //强制让s6指向常量池中的"ab";
        System.out.println(s4==s6.intern());//true

        //使用final来修饰字符串变量,拼接的结果仍在常量池中
        final String s7="a";
        String s8=s7+"b";
        System.out.println(s4==s8);//true

        System.out.println(s4==getStr());//true

        System.out.println(s4==getStr2());//false
    }

    public static String getStr(){
        return "ab";
    }

    public static String getStr2(){
        return new String("ab");
    }
}
