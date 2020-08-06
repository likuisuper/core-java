package tech.aistar.day13;

/**
 * 本类功能:泛型方法
 *
 * 假设某个类中就那么几个方法需要使用泛型,那么就没有必要设置成泛型类
 *
 * @author cxylk
 * @date 2020/8/6 12:51
 */
public class GenericDemo {
    /**
     * 无返回类型
     * @param e
     * @param <E>
     */
    public <E> void show(E e){
        System.out.println(e);
    }

    /**
     * 带返回类型
     * @param t
     * @param <T>
     * @return
     */
    public <T> T add(T t){
        return t;
    }

    public static <T> T find (T t){
        return t;
    }
}

class GenericTest{
    public static void main(String[] args) {
        GenericDemo g1=new GenericDemo();
        g1.show("ok");

        Integer n=g1.add(100);
        System.out.println(n);

        System.out.println(GenericDemo.find(3.14));
    }
}
