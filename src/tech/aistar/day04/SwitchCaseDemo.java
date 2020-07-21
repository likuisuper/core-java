package tech.aistar.day04;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/21 21:21
 */
public class SwitchCaseDemo {
    public static void main(String[] args) {
        //[90 - 100] - 优秀
        //[80 - 90) - 良好

        int score = 98;

        int n = score / 10;
        switch (n){
            case 9:
            case 10:
                System.out.println("优秀!");
                break;
            case 8:
                System.out.println("良好");
                break;
            default:
                System.out.println("好好努力!");
                break;
        }
    }
}
