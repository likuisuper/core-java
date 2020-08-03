package tech.aistar.day11;

import java.util.Arrays;

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
        System.out.println(str2);

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
        //返回 char 数组参数的字符串表示形式。
        System.out.println(String.valueOf(chars));//abcdef
    }
}
