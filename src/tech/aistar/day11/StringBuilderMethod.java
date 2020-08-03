package tech.aistar.day11;

/**
 * 本类功能:StringBuilder常用方法
 *
 * @author cxylk
 * @date 2020/8/3 21:06
 */
public class StringBuilderMethod {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();

        //1.append(int i)
        sb.append(2);
        sb.append(3);
        sb.append(1);
        System.out.println(sb.toString());//231

        //2.append(String str)
        sb.append("ABCDE");
        System.out.println(sb.toString());//231ABCDE

        //3.deleteCharAt(int index)
        //移除此序列指定位置上的 char。
        sb.deleteCharAt(4);//如果移除8的话会报错 java.lang.StringIndexOutOfBoundsException
        System.out.println(sb.toString());//231ACDE

        //4.delete(int start,int end)
        //移除此序列的子字符串中的字符。(不包含end)
        sb.delete(3,5);
        System.out.println(sb.toString());//231DE

        //5.indexOf(String str)
        // 返回第一次出现的指定子字符串在该字符串中的索引
        System.out.println(sb.indexOf("DE"));//3

        //6.insert(int offset, char c)
        //将 char 参数的字符串表示形式插入此序列中。
        sb.insert(4,'g');
        System.out.println(sb.toString());//231DgE

        //7.insert(int offset,String str)
        sb.insert(2,"lol");
        System.out.println(sb.toString());//23lol1DgE

        //8.reverse()
        //将此字符序列用其反转形式取代。
        sb.reverse();
        System.out.println(sb.toString());//EgD1lol32

        //9.subSequence(int start, int end)
        //返回一个新字符序列，该字符序列是此序列的子序列。 - 不包含结束索引end
        System.out.println(sb.subSequence(2,6));//D1lo
    }
}
