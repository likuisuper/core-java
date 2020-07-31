package tech.aistar.design.template.callback;

/**
 * 本类功能:回调接口
 * public class CallbackTemplate
 * 可以将class替换成interface,即用回调接口替代模板类
 *
 * @author cxylk
 * @date 2020/7/31 19:39
 */
public interface CallbackTemplate {
    public static void execute(ICallback callback){
        System.out.println("1.加载驱动...");
        System.out.println("2.连接DB");

        //写sql语句
        callback.executeSql();

        System.out.println("4.释放资源..");
    }
}
