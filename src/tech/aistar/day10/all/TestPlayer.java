package tech.aistar.day10.all;

/**
 * 本类功能:测试类
 *
 * @author cxylk
 * @date 2020/7/31 16:10
 */
public class TestPlayer {
    public static void main(String[] args) {
        //创建两个相声演员的对象
        Player yueyue=new DouGen();
        yueyue.setName("岳岳");

        Player syy=new PenGen();
        syy.setName("孙悦");

        //创建接口对象
        IPlayer p1=new PlayerDouImpl();

        p1.play(yueyue);

        System.out.println("=========");

        IPlayer p2=new PlayerPenImpl();

        p2.play(syy);
    }
}
