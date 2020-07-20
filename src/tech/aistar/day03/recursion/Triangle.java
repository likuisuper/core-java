package tech.aistar.day03.recursion;

/**
 * 本类功能:给出行和列，输出该行该列上对应的杨辉三角值
 *
 * @author cxylk
 * @date 2020/7/20 12:22
 */
public class Triangle {
    public int yangHui(int x,int y){//x代表行，y代表列
        if(x==y||y==1){//如果行和列相等或者列为1
            return 1;
        }
        return yangHui(x-1,y-1)+yangHui(x-1,y);//左上的数+上面的数
    }

    public static void main(String[] args) {
        Triangle t=new Triangle();
        System.out.println(t.yangHui(4,4));
    }
}
