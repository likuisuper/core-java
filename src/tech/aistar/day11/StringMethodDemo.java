package tech.aistar.day11;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;

/**
 * 本类功能:字符串常用方法
 *
 * @author cxylk
 * @date 2020/8/3 19:11
 */
public class StringMethodDemo {
    public static void main(String[] args) {
        //1.charAt(int index) 返回指定索引处的char值
        //索引从0开始,到length-1
        String str="abcdefdttgc";
        char index=str.charAt(3);
        System.out.println(index);

        //2.contains
        String str1="abc";
        System.out.println(str.contains(str1));//str包含str1,返回true

        //3.copyValueOf(char[] data)
        char[] chars={'a','b','c','d','e','f'};
        String str2=String.copyValueOf(chars);
        System.out.println(str2);//abcdef

        //copyValueOf(char[] date,int start,int count)
        String str3=String.copyValueOf(chars,0,4);//从0开始，长度为4
        System.out.println(str3);//返回abcd

        //4.getBytes()
        byte[] bytes=str.getBytes();
        System.out.println(Arrays.toString(bytes));//[97, 98, 99, 100, 101, 102, 100, 116, 116, 103]

        //5.getChars
        char[] chars1={'a','b','c','d','f','m'};
        //要复制的最后一个字符位于索引srcEnd-1处
        str.getChars(2,5,chars1,3);
        System.out.println(chars1);//abccde

        //6.indexOf(int ch)
        //返回指定字符在此字符串中第一次出现处的索引
        System.out.println(str.indexOf('c'));//2

        //7.indexof(int ch,int fromIndex)
        // 返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索
        System.out.println(str.indexOf('c',4));//10

        //8.indexof(String str)
        //返回指定子字符串在此字符串中第一次出现处的索引。
        System.out.println(str.indexOf("agc"));//-1
        System.out.println(str.indexOf("tgc"));//8

        //9.indexOf(String str, int fromIndex)
        //返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。
        System.out.println(str.indexOf("abc",5));//-1

        //10.lastIndexOf(int ch)
        //返回指定字符在此字符串中最后一次出现处的索引。
        System.out.println(str.lastIndexOf('g'));

        //11.lastIndexOf(int ch, int fromIndex)
        //返回指定字符在此字符串中最后一次出现处的索引，从指定的索引处开始进行反向搜索。

        //12.lastIndexOf(String str)
        //返回指定子字符串在此字符串中最右边出现处的索引。

        //13.lastIndexOf(String str, int fromIndex)
        // 返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索。


        //14.split(String regex) split(String regex, int limit)
        //根据给定正则表达式的匹配拆分此字符串
        String strs="a b c d e f dttgc";
        String[] str4=strs.split(" ",5);
        System.out.println(Arrays.toString(str4));//[a, b, c, d, e, f, dttgc]
        //加上limit(限定的长度)后，结果为[a, b, c, d, e f dttgc]

        //15.substring(int beginIndex)
        // 返回一个新的字符串，它是此字符串的一个子字符串。
        System.out.println(str.substring(3));//defdttgc

        //16.substring(int beginIndex, int endIndex)
        //返回一个新字符串，它是此字符串的一个子字符串。索引只能到endIndex-1
        System.out.println(str.substring(4,8));//efdt

        //17.toCharArray()
        //将此字符串转换为一个新的字符数组
        char[] chars2=strs.toCharArray();
        System.out.println(Arrays.toString(chars2));//[a,  , b,  , c,  , d,  , e,  , f,  , d, t, t, g, c]

        //18.String valueOf(char c)
        // 返回 char 参数的字符串表示形式。
        System.out.println(String.valueOf('你'));

        //19.valueOf(char[] data)
        //返回 char 数组参数的字符串表示形式。 ·
        System.out.println(String.valueOf(chars));//abcdef

        //构造
        String s1 = new String();// ""空字符串
        String s2 = null;//null

        //把字符串转换成byte[]
        // byte[] bytes = "good".getBytes();
        byte[] bytes1 = new byte[0];
        try {
            //utf-8编码下,一个汉字占3个字节,字母数字符号仅占一个字节
            //gbk编码下,一个汉字占2个字节,字母数字符号仅占一个字节
            bytes = "孙子abc".getBytes("gbk");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //加密操作
        for (int i = 0; i < bytes.length; i++) {
            //bytes[i]^=888;
            System.out.println(bytes[i]);
        }

        ////利用字节数组来构建一个字符串对象
        //String(byte[] byte);
        String byteStr = new String(bytes);
        System.out.println(byteStr);


        //1. format方法
        System.out.println(String.format("%tF",new Date()));//2020-08-04
        System.out.println(String.format("%tT",new Date()));//14:26:41

        //2.获取字符串长度
        System.out.println("abd".length());

        //3.判断字符串是否为空,判断字符串的长度是否为0
        System.out.println(" ".isEmpty());//false

        //4. 根据下标获取字符串中的指定字符,返回char类型
        //字符串的下标也是范围的[0,字符串长度-1]
        //如果不在这个范围,java.lang.StringIndexOutOfBoundsException字符串下标越界异常
        System.out.println("abc".charAt(2));

        //5. 字符串的比较
        System.out.println("abc".equals("abc"));//true

        //6. 忽略大小写的比较
        System.out.println(true);//true

        //int compareTo
        System.out.println("a".compareTo("b"));//-1 负数
        System.out.println("b".compareTo("a"));//1 正数
        System.out.println("a".compareTo("a"));//0 零

        //6. 判断前缀
        System.out.println("JavaScript".startsWith("Java"));//true

        //7. 判断后缀.
        System.out.println("xx.gif".endsWith(".gif"));//筛选文件的.

        //8. 找出指定的字符串在原来的字符串中第一次出现的下标的位置
        System.out.println("abcbc".indexOf('b'));//1

        //从下标2开始继续寻找以后第一次出现'b'字符的下标
        System.out.println("abcbc".indexOf('b',2));//3

        //9. lastIndexOf

        //10. 截取
        String s5 = "hello world";
        String result = s5.substring(0);

        System.out.println(s5 == result);//true

        System.out.println("result:"+result);//ello world
        System.out.println("s5:"+s5);//hello world

        //[1,3) - 下标
        String result2 = s5.substring(1,3);
        System.out.println(result2);//el

        System.out.println("el" == result2);//false

        //11. 在字符串的末尾进行拼接
        String s7 = "abc";
        String s8 = s7.concat("de");//没有让s7重新指向新的扩容之后的char[]

        System.out.println(s8);

        //YY -> 如果调用一个方法之后,有返回类型,几乎就没有对原来对象进行改变
        //      如果没有返回类型,大致是对原来的对象进行改变了.

        System.out.println("abcde" == s8);//false

        //replace替换
        //I Love java
        System.out.println("I Love Girl".replace("Girl","java"));

        //
        System.out.println("I Love Girl".replace("ov",""));

        //boolean match(String s);
        //正则表达式
        String username = "23";
        if(username.matches("[0-9]+")){
            System.out.println("匹配成功!");
        }else{
            System.out.println("匹配失败!");
        }
    }
}
