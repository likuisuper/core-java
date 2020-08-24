package tech.aistar.design.proxy2.dynamic;


/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/24 20:25
 */
public class SmsServiceImpl implements SmsService{
        //获取实现类实现的接口
//        Class<?> clazz= null;
//        try {
//            clazz = Class.forName("tech.aistar.design.proxy2.dynamic.SmsServiceImpl");
//            Class<?>[] classes=clazz.getInterfaces();
//            for (Class<?> aClass : classes) {
//                System.out.println(aClass.getSimpleName());
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
        @Override
        public String send(String message){
            System.out.println("send message:" + message);
            return message;
        }
}
