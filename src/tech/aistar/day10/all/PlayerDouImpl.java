package tech.aistar.day10.all;

/**
 * 本类功能:逗哏实现类
 *
 * @author cxylk
 * @date 2020/7/31 16:06
 */
public class PlayerDouImpl implements IPlayer{

    @Override
    public void play(Player player) {
//        //一套业务流程
//        System.out.println("开幕");
//
//        System.out.println(player.getName()+"演员登场...");
//
//        System.out.println("开始逗哏表演...");
//
//        System.out.println("落幕退场...");

        PlayerTemplate t=new PlayerTemplate() {
            @Override
            public void play() {
                System.out.println("开始逗哏表演!!!...");
            }
        };
        t.start(player);
    }
}
