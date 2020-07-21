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
        triangle(8);
    }

    /**
     * 内层循环和外层循环无关的
     * 输出实心的正方形
     * @param n 边长
     */
    public static void square(int n){
        //外层循环执行一次，内层循环执行全部
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //System.out.print("#");
                //格式化输出
                System.out.printf("%2s","#");
            }

            //换行...
            //System.out.println();
            System.out.print("\n");
        }
    }

    /**
     * 内层循环和外层循环相关
     */
    public static void triangle(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    public static void triangle2(int n){
        for (int i = 0; i < n; i++) {
            for(int j=0;j<=n;j++){
                if(j==0||i==j||i==n-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();//列后换行
        }
    }

    /**
     * 九九乘法表 双层for循环
     * @param n
     */
    public static void nine(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+"*"+j+"="+i*j+"\t");
            }
            System.out.println();
        }
    }
}
