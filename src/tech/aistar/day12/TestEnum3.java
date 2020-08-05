package tech.aistar.day12;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/5 19:50
 */
public class TestEnum3 {
    public static void main(String[] args) {
        //获取冬天的
        EnumDemo3 e=EnumDemo3.WINTER;

        for(;;){
            e=e.next();
            System.out.println(e+":"+e.getSign());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
