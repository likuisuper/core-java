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
        String a = "aaavvvvsdsdcfqwfas";
        String b = "vvvvaaafasaddsdsd";
        maxComString(a,b);
    }

    public static void maxComString(String str1,String str2){
        String c = null;
        for (int i = 0;i < str1.length();i++){
            for (int j = str1.length(); j > i; j--) {
                if (str2.contains(str1.substring(i,j))){
                    // System.out.println(a.substring(i,j));
                    if (c == null){
                        c = str1.substring(i,j);
                        break;
                    }
                    if (c.length() < str1.substring(i,j).length()){
                        c = str1.substring(i, j);
                    }
                    else if (c.length() == str1.substring(i,j).length()){
                        System.out.println(str1.substring(i,j));
                    }
                }
            }
        }
        System.out.println(c);
    }

}
