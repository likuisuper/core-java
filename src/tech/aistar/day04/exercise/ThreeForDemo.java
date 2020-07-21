package tech.aistar.day04;

/**
 * 本类功能:输出所有的三位数
 *
 * 要求：
 *
 *  1.这个三位数由数字1,2,3,4中的三个数字组成
 *  2.不能出现重复的数字
 *  3.每6个换一行输出
 *
 * @author cxylk
 * @date 2020/7/21 9:45
 */
public class ThreeForDemo {
    public static void main(String[] args) {
        //定义一个计数器
        int count=0;

        for (int x = 1; x <=4 ; x++) {
            for (int y = 1; y <=4 ; y++) {
                for (int z = 1; z <=4 ; z++) {
                    if(x!=y&&x!=z&&y!=z){//不能出现两两重复
                        System.out.print(x+""+y+z+"\t");
                        count++;
//                        if(count%6==0)//当count很大的时候，再对6取余计算量很大
//                            System.out.println();
                        //优化
                        if(count==6){
                            System.out.println();
                            count=0;//将count置零
                        }
                    }
                }
            }
        }
    }
}
