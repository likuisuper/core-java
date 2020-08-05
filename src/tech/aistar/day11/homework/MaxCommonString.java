package tech.aistar.day11.homework;

/**
 * 本类功能:
 *    第一个串: abcdededeffffffoo
 *    第二个串: ffffffpopodededekkk
 *
 *    找俩个字符串中的最大长度的公串.
 *    dedede ffffff
 *
 * @author cxylk
 * @date 2020/8/3 20:56
 */
public class MaxCommonString {
    public static void main(String[] args) {
//        String a = "aaavvvvsdsdcfqwfas";
//        String b = "vvvvaaafasaddsdsd";
        String s1 = "dddddeoeospsffffffe";
        String s2 = "affffffedfdddddd09";
        System.out.println(maxComString(s1,s2));
    }

    public static String maxComString(String firstStr,String secStr) {
        //由于最大长度的公串有可能出现多个
        StringBuilder sb = new StringBuilder();

        //定义一个变量
        int len = 0;

        //1.遍历firstStr - 得出第一个字符串的所有的子集
        for (int i = 0; i < firstStr.length(); i++) {
            boolean flag=true;
            for (int j = i + 1; j <= firstStr.length(); j++) {//这里能取等号是因为subString截取不到最后长度
                //获取当前的firstStr的子串
                String subStr = firstStr.substring(i, j);
                //获取这个子串的长度
                int length = subStr.length();

                //判断secStr中是否包含这个subStr
                if (secStr.contains(subStr) && length > len) {
                    //考虑是否要将subStr放入到StringBuilder中
                    //清空builder
                    sb.delete(0, sb.capacity());
                    sb.append(subStr + "\t");
                    len = length;
                } else if (secStr.contains(subStr) && length == len) {
                    sb.append(subStr);
                }
                flag=false;
            }
            if(flag)
                break;
        }
        return sb.toString();
    }
}
