package tech.aistar.day08.relation.onetoone;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/28 18:20
 */
public class TestHusband {
    public static void main(String[] args) {
        Husband husband=new Husband(1,"张三",null);

        Wife wife=new Wife(2,"小兰",null);

        //应该做的双向关联 - 所以需要双向绑定
        husband.setWife(wife);

        wife.setHusband(husband);

        System.out.println(husband);//就是调用它的toString方法
        System.out.println(husband.getWife());

        System.out.println(wife);
        System.out.println(wife.getHusband());
    }
}
