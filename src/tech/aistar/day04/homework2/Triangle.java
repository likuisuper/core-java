package tech.aistar.day04.homework2;

/**
 * 本类功能:给定一个行数，输出杨辉三角
 * <p>
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 *
 * @author cxylk
 * @date 2020/7/21 17:44
 */
public class Triangle {
    public static void main(String[] args) {
        print(5);
    }

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    System.out.print(1 + "\t");
                } else {
                    System.out.print(yangHui(i, j) + "\t");
                }
                if(i==j)
                    System.out.println();
            }
        }
    }

    public static int yangHui(int x, int y) {
        if (x == y || y == 0)
            return 1;
        return yangHui(x - 1, y - 1) + yangHui(x - 1, y);
    }
}
