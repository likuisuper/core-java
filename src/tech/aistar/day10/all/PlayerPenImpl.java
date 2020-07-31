package tech.aistar.day10.all;

/**
 * 本类功能:捧哏实现类
 *
 * @author cxylk
 * @date 2020/7/31 16:09
 */
public class PlayerPenImpl implements IPlayer{
    @Override
    public void play(Player player) {
//        //一套业务流程
//        System.out.println("开幕");
//
//        System.out.println(player.getName()+"演员登场...");
//
//        System.out.println("开始捧哏表演...");
//
//        System.out.println("落幕退场...");
        PlayerTemplate p=new PlayerTemplate() {
            @Override
            public void play() {
                System.out.println("开始捧哏表演");
            }
        };
        p.start(player);
    }
}
