package tech.aistar.day02;

/**
 * @Author 箜絔lk
 * @Date 2020/7/17 18:47
 */
public class JVMType {
    public static void main(String[] args) {
        int n=2;
        while(n>1){
            System.out.println("while...");
        }
        //如果是while(2>1),会编译错误，提示unreachable statement
        /*
        因为jvm执行到2>1的时候，由于2就是字面量，已经确定了值，jvm就可以
        精确的知道它的比较结果，必然是true

        但是当你使用while(n>2),jvm遇到变量n，不会关系n的具体的保存的数值。
        只会关心这个变量的数据类型 - 决定了这个变量可变化的范围
        认为n是有可能小于数字1的，while下面的代码就有可能会执行，所有不会报错

         */
        System.out.println("===");
    }

    byte b=100;//100是一个字面量，底层继续判断100是否在byte类型的范围[-128-127]
                //然后继续在底层进行强制类型转换[int->byte]->存储

    //因为m是一个变量，jvm就会认为m浮动范围是在Int的范围，就有可能会在byte类型范围之外
    //不允许这种风险发生在程序的运行期间，所以就要求必须在程序的编译期间进行强制类型转换
    int m=100;
    byte bt=(byte)m;
}
