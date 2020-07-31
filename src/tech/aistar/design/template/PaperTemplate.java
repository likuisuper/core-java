package tech.aistar.design.template;

/**
 * 本类功能:模板设计模式
 *
 * @author cxylk
 * @date 2020/7/31 12:45
 */
public abstract class PaperTemplate {

    //固定的业务模板结构
    public void test01(){
        System.out.println("Java是面向对象语言吗?");
        System.out.println("A. 是  B.否");
        System.out.println("答案是:"+answer01());
    }

    public void test02(){
        System.out.println("Python是面向对象语言吗?");
        System.out.println("A. 是  B.否");
        System.out.println("答案是:"+answer02());
    }

    //抽象方法 - 具体的细节延迟到子类去实现
    public abstract String answer01();

    public abstract String answer02();

    //定义一个方法用来执行这些业务流程,控制好业务流程的顺序
    public final void exam(){
        //控制好业务执行的顺序
        test01();

        test02();
    }
}
