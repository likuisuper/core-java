package tech.aistar.day04;

/**
 * 本类功能:continue和break
 *
 * @author cxylk
 * @date 2020/7/21 15:21
 */
public class ContinueAndBreak {
    public static void main(String[] args) {
        for(int i=0;i<6;i++){
            if(i==3)
                continue;//跳过本轮循环，但是会继续下一轮循环
                        //当执行到continue语句的时候，下面的代码将不再执行
            System.out.println(i);
        }

        System.out.println();

        int count=0;

        //cxylk代码块的名称
        cxylk:{
            if(count==0)
                break cxylk;//break代码块名称；跳出代码块
            System.out.println("代码块");
        }

        System.out.println("outside");

        for (int i = 0; i < 6; i++) {
            if(i==3)
                break;//打破当前所在的这一层循环
            System.out.println(i);
        }

        for (int i = 0; i <6 ; i++) {
            for(int j=0;j<6;j++){
                if(j==2){
                    break;
                }
                System.out.println(i+"->"+j);
            }
        }
    }
}
