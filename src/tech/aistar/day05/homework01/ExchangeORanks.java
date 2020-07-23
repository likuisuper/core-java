package tech.aistar.day05.homework01;

import java.util.Arrays;

/**
 * 本类功能:行列调换
 *
 * @author cxylk
 * @date 2020/7/23 19:40
 */
public class ExchangeORanks {
    public static void main(String[] args) {
        test();

    }

    public static void test(){
        String[][] str={{"白","日","依","山","尽"},{"黄","河","入","海","流"},{"欲","穷","千","里","目"},
                {"更","上","一","层","楼"}};
        //定义一个新的数组
        String[][] s=new String[str[1].length][str.length];
        //遍历原数组
        for(int i=0;i<str.length;i++){
                for(int j=0;j<s.length;j++){
                    s[j][i]=str[i][j];
                }
        }

        for (int i = 0; i < s.length ; i++) {
            System.out.println(Arrays.deepToString(s[i]));
        }
    }
}
