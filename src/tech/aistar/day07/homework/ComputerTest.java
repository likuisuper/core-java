package tech.aistar.day07.homework;

/**
 * 本类功能:电脑测试类
 *
 * @author cxylk
 * @date 2020/7/27 18:49
 */
public class ComputerTest {
    public static void main(String[] args) {

        Monitor monitor=new Monitor("三星",36,"LED");


        Computer cp=new Computer("联想",40089.5,"最新一代的联想电脑",monitor);

        System.out.println(cp);
    }
}
