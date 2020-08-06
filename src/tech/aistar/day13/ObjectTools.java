package tech.aistar.day13;

/**
 * 本类功能:泛型类
 *
 * @author cxylk
 * @date 2020/8/6 12:32
 */
public class ObjectTools<T> {
    public T get(T t){
        return t;
    }

    //没有泛型的时候 - 都是使用object类型
    public Object find(Object obj){
        return obj;
    }
}

class TestTools{
    public static void main(String[] args) {
        //泛型 - 定义在类，定义方法时期并没有明确确定类型
        //类型的确定延迟到创建对象或者调用方法的时候
        ObjectTools<String> tools=new ObjectTools<>();

        String result01=tools.get("ok");

        //编译期间一旦不会出现问题,程序运行期间就不会抛出类型转换失败异常
        //Integer tt=tools.get("ok");

        System.out.println(result01);

        ObjectTools<Integer> tools1=new ObjectTools<>();
        Integer result02=tools1.get(200);
        System.out.println(result02);

        //没有泛型的时候
        ObjectTools t=new ObjectTools();

        //编译期间是正常的,但是运行期间存在类型转换失败的风险
        Integer s=(Integer)t.find("ok");
        System.out.println(s);//抛出异常
    }
}
