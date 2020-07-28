package tech.aistar.day07;

/**
 * 本类功能:对象数组
 *
 * @author cxylk
 * @date 2020/7/28 21:02
 */
public class TestUserArrayDemo {
    public static void main(String[] args) {
        //创建一个User数组,长度3个
        User[] users=new User[3];

        User u1=new User(1,"admin");
        User u2=new User(2,"tom");
        User u3=new User(3,"james");

        //放入到数组中去
        users[0]=u1;
        users[1]=u2;
        users[2]=u3;

        //遍历数组
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i]);
        }

        System.out.println("======");

        for(User u:users){
            System.out.println(u);
        }
    }
}
