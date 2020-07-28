package tech.aistar.day07;

import tech.aistar.util.DateUtil;

import java.util.Date;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/28 21:22
 */
public class UserTest {
    public static void main(String[] args) {
        User user=new User();//对象是具体的

        user.setId(100);
        user.setUsername("习大大");

        user.setPassword("abc123");

        user.setRegisterDate(new Date());

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        String strDate= DateUtil.format(user.getRegisterDate(),"yyyy-MM-dd HH:mm:ss");

        System.out.println(strDate);

        User u1=new User();

        System.out.println(u1.getId());
    }
}
