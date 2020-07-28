package tech.aistar.day04;

/**
 * 本类功能:双层for循环
 *
 * @author cxylk
 * @date 2020/7/21 20:46
 */
public class ForTwoDemo {
    public static void main(String[] args) {
        //square(5);
        triangle2(8);
        //hollowDiamond();
        nine(9);
        solidDiamond();
    }

    /**
     * 内层循环和外层循环无关的
     * 输出实心的正方形
     *
     * @param n 边长
     */
    public static void square(int n) {
        //外层循环执行一次，内层循环执行全部
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.print("#");
                //格式化输出
                System.out.printf("%2s", "#");
            }

            //换行...
            //System.out.println();
            System.out.print("\n");
        }
    }

    /**
     * 内层循环和外层循环相关
     * 打印实心正三角形
     */
    public static void triangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    /**
     * 打印空心正三角形
     *
     * @param n
     */
    public static void triangle2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || i == j || i == n - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();//列后换行
        }
    }

    /**
     * 九九乘法表 双层for循环
     *
     * @param n
     */
    public static void nine(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }

    /**
     *空心菱形
     *     *
     *    *  *
     *   *    *
     *  *      *
     * *        *
     *  *      *
     *   *    *
     *    *  *
     *     *
     *
     * i代表行,j代表列，都是从0开始
     * 左上 - i=0 j=4     i=1  j=3   即 i+j=4
     * 右上 - i=0 j=4     i=1  j=5   即 j-i=4
     * 左下 - i=4 j=0     i=5  j=1   即 i-j=4
     * 右下 - i=4 j=8     i=5  j=7   即 i+j=12
     */
    public static void hollowDiamond() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i + j == 4 || j - i == 4 || i - j == 4 || i + j == 12)
                    System.out.print("*");
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * 实心菱形
     */
    public static void solidDiamond(){
        for (int i = 0; i < 9; i++) {
            for(int j=0;j<9;j++){
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
