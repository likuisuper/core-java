package tech.aistar.day13.exception;

/**
 * 本类功能:finally的使用以及几个坑的问题
 *
 * @author cxylk
 * @date 2020/8/6 20:04
 */
public class FinallyDemo {
    public static void main(String[] args) {
        //add();

        //System.out.println(test01());

        System.out.println(test02());


        //System.out.println(inc());
    }

    /**
     * 当try中出现了return语句[结束整个方法的] - 请问finally中的代码是否执行
     *
     * return 语句是在finally语句之后执行的
     */
    public static void add(){
        try{
            int i=0;
            System.out.println("try...");

            //return语句是在finally语句之后执行的
            return;//结束整个方法的
        }finally {
            System.out.println("finally...");
        }
    }

    public static int test01(){
        int i=0;
        try{
            ++i;//i 计算的结果 - 局部变量表中[临时的存储位置]

            return i;//返回1
        }finally {
            ++i;
            System.out.println(i);//输出2
            //return i;//返回2
        }
    }

    public static int test02(){
        int i=0;
        try{
            ++i;
            return i;
        }finally {
            return ++i;//finally中一旦出现了return语句,会对局部变量表存储的i产生影响
        }
    }

    public static int inc(){
        int x;
        try{
            x=1;
            //Class.forName("xxx.xx");
            //int n=test5(5);
            return x;

        }catch (Exception e){
            //int n=test5(5);
            x=2;

            return x;
        }finally {
            x=3;
            System.out.println(x);
            //return 3;
        }
    }

    public static int test5(int n){
        return n*test5(n-1);
    }

}
