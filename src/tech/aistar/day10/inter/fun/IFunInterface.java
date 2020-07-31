package tech.aistar.day10.inter.fun;

/**
 * 本类功能:
 * 函数式接口的作用 - 集合知识点
 * 函数式接口中只能拥有唯一的一个抽象方法
 *
 * @author cxylk
 * @date 2020/7/31 18:55
 */
public interface IFunInterface {
    //public abstract void add(int x);

    //void add(int x);

    void update(int x,String y);

    //void find();
}
class TestFun{
    public static void main(String[] args) {
//        IFunInterface fun=new IFunInterface() {
//            @Override
//            public void add(int x) {
//                System.out.println("x:"+x);
//            }
//        };
//        fun.add(10);
//
//        System.out.println("========");

        //为什么要有函数式接口
        //主要是为了配合jdk8.x提供的lambda表达式使用
        //lambda - js箭头函数 -> 简化语法 -> 匿名内部类语法

        //void add(int x);
        //如果重写的方法体中的代码只有一行,那么{}是可以省略不写的
//        IFunInterface f2= (x) -> System.out.println("x:"+x);
//        f2.add(100);

        //void update(int x,String y);
//        IFunInterface f3=new IFunInterface() {
//            @Override
//            public void update(int x, String y) {
//                System.out.println("x:"+x);
//                System.out.println("y:"+y);
//            }
//        };
//        f3.update(12,"admin");
//
        //1.找参数的个数
        //2.写方法体中的代码
        //这里的参数名字写成什么都可以
        IFunInterface f4=(a,b) -> {
            System.out.println("a:"+a);
            System.out.println("b:"+b);
        };
        f4.update(100,"cxy");

//        IFunInterface f5=() -> {
//            System.out.println("ab");
//        };
//        f5.find();//输出ab
    }
}
