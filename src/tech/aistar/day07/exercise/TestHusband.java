package tech.aistar.day07.exercise;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/28 20:43
 */
public class TestHusband {
    public static void main(String[] args) {
        Husband husband=new Husband();
        husband.setId(1);
        husband.setName("陈冲");

        //准备一个妻子对象
        Wife wife=new Wife();
        wife.setId(1);
        wife.setName("小霞");

        husband.setWife(wife);

        //设置husband的妾
        Concubine[] qies=new Concubine[2];
        //创建两个妾的对象
        Concubine c1=new Concubine(1,"凤姐");
        Concubine c2=new Concubine(2,"芙蓉");

        qies[0]=c1;
        qies[1]=c2;

        //设置妾的值
        husband.setConcubines(qies);

        System.out.println(husband);
    }
}
