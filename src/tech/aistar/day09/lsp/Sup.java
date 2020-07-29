package tech.aistar.day09.lsp;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/29 19:21
 */
public class Sup {
    public void test01(Father father){
        System.out.println("Sup01...");
    }

    public void test02(FatherSub fatherSub){
        System.out.println("Sup02...");
    }
}

class Sub extends Sup{
    public void test01(FatherSub fatherSub){
        System.out.println("Sub01...");
    }

    public void test02(Father father){
        System.out.println("Sub02...");
    }

}

class TestSub{
    public static void main(String[] args) {
        FatherSub fatherSub=new FatherSub();



        Sup sup=new Sup();
        sup.test01(fatherSub);//Sup01... 不推荐用这个

        //里氏替换原则 - 但凡可以使用父类的地方，也是允许使用子类
        //一旦使用子类Sub来替代Sup父类，期望得到的效果实际上是一样的，但是实际上不一样 - 不能够替换
        Sub sub=new Sub();
        sub.test01(fatherSub);//Sub01...

        System.out.println("======里氏替换原则=======");

        //又在使用父类
        Sup sup1=new Sup();
        sup1.test02(fatherSub);//Sup02..

        //使用子类Sub替换
        Father father=new Father();

        Sub sub1=new Sub();

        sub1.test01(father);//Sup01

        //sub1.test02(father);//Sub02

        //sub1.test01(fatherSub);//Sub01

        //因为test02里面的参数是father,找不到fatherSub,所以要去
        sub1.test02(fatherSub);//Sup02


    }
}
