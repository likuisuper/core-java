package tech.aistar.day13.exception;

import java.io.FileNotFoundException;

/**
 * 本类功能:异常的消极处理
 *
 * @author cxylk
 * @date 2020/8/6 19:52
 */
public class ThrowsDemo {
    //千万不要把异常抛给main,等同于抛给了JVM,一旦发生了异常就会中断
    public static void main(String[] args) {
        //选择在方法的最终调用的地方统一进行积极处理
        try {
            add();
            try {
                test01();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        test02();
    }

    /**
     * 此方法没有处理异常,而是抛出异常
     * @throws ClassNotFoundException
     */
    public static void add() throws ClassNotFoundException {
        Class.forName("xxx.xx");
    }

    /**
     * 应用场景 - 会在程序代码中抛出自定义的异常
     * @throws FileNotFoundException
     */
    public static void test01() throws FileNotFoundException {
        throw new FileNotFoundException("文件不存在");
    }

    public static void test02(){
        //如果方法中throw运行时异常的对象的时候,是不会强制要求在方法的签名上throws的
        throw new RuntimeException("运行时异常");
    }
}
