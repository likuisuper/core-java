package tech.aistar.day04.homework2;

/**
 * 本类功能:打印菱形
 *
 * @author cxylk
 * @date 2020/7/25 20:07
 */
public class ShapeDemo {
    public static void main(String[] args) {

        //test();

        test02();
    }

    /**
     * 打印空心菱形
     *
     *     *
     *    * *
     *   *   *
     *  *     *
     * *       *
     *  *     *
     *   *   *
     *    * *
     *     *
     *
     *  左上 - i=0  j=4  i=1  j=3
     *
     *  右上 - i=0  j=4  i=1  j=5
     *
     *  左下 - i=4  j=0  i=5  j=1
     *
     *  右下 - i=4  j=8  i=5  j=7
     */
    public static void test(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(i+j==4||j-i==4||i-j==4||i+j==12){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    /**
     * 打印实行菱形
     */
    public static void test02(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(i+j<4||j-i>4||i-j>4||i+j>12){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
