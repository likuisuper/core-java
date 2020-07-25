package tech.aistar.day05.homework01;

import java.util.Arrays;

/**
 * 本类功能:行列调换
 *
 * @author cxylk
 * @date 2020/7/23 19:40
 */
public class ExchangeOfRanks {
    public static void main(String[] args) {
        String[][] str={
                {"白","日","依","山","尽","，"},
                {"黄","河","入","海","流","，"},
                {"欲","穷","千","里","目","，"},
                {"更","上","一","层","楼","。"}
        };
        test01(str);

        //test02(str);
    }

    /**
     * 先把二维数组放入一个一维数组中
     * [白,日,依,山,尽，,黄,河,入,海,流,。欲,穷,千,里,目，,.......]
     *
     * 白黄 .. -> 第一行 ->0   6   12    18
     * 日河 .. -> 第二行 ->1   7   13    19
     * ...     -> 第三行 ->2   8   14    20
     *
     * i和j满足什么关系 ? i,j=0  -> 0   i=0,j=1 ->6   j*6+i=6
     *                  i,j=1   ->1    i=1,j=1 ->7  j*6+i=7
     *
     * @param arr
     */
    public static void test01(String[][] arr){
        //先将二维数组中的所有元素放入到一维数组中
        //一维数组的长度就是二维数组行的长度*列的长度
        String[] temp=new String[arr.length*arr[0].length];

        int pos=0;

        //给一维数组赋值
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                temp[pos++]=arr[i][j];
            }
        }

        //输出
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(temp[j*6+i]);
            }
            System.out.println();
        }
    }

    /**
     * 利用二维数组的行列特性
     * @param arr
     */
    public static void test02(String[][] arr){
        //定义一个二维数组
        String[][] str=new String[6][4];//行的长度就是原来列的长度,列的长度就是原来行的长度

        //竖着的列行=横着的行列
        for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[i].length;j++){
                    str[j][i]=arr[i][j];
                }
        }

        for (int i = 0; i < str.length ; i++) {
            for (int j = 0; j < str[i].length; j++) {
                System.out.print(str[i][j]);
            }
            System.out.println();
        }
    }
}
