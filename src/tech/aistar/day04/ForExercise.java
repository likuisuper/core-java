package tech.aistar.day04;

/**
 * 本类功能:for循环 - 复合形态(九九乘法表)
 *
 * @author cxylk
 * @date 2020/7/20 16:59
 */
public class ForExercise {
    public static void main(String[] args) {
        //九九乘法表,i代表行,j代表列
        for(int i=1,j=1;i<=9;j++){//因为i只有等于j的时候才会换行，所以这里不用写i++
            System.out.print(i+"*"+j+"="+i*j+"\t");
            //当行和列相等时换行
            if(i==j){
                System.out.println();
                i++;//换行之后让i+1
                j=0;//j从0开始，在for循环括号里j++,让j=1
            }
        }
    }
}
