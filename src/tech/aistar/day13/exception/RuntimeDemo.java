package tech.aistar.day13.exception;

/**
 * 本类功能:运行时异常
 *
 * @author cxylk
 * @date 2020/8/6 19:44
 */
public class RuntimeDemo {
    public static void main(String[] args) {

        //不加异常处理的时候,当出现异常处理,异常下方的代码将不会执行了

        try{
            //如果try中的代码发送了异常,那么就会进入到对应的catch块中去执行
            String s=null;
            System.out.println(s.length());
        }catch (Exception e){
            //打印异常的堆栈信息
            //e.printStackTrace();
            System.out.println("ArithmeticException");

            //未来，进行程序运行时候的日志的记录，方便以后来来排错
        }

        //只要对异常进行了处理，那么可以保证程序中一旦出现了异常
        //但是整个程序还是可能继续向下执行的

        System.out.println("===end");
    }
}
