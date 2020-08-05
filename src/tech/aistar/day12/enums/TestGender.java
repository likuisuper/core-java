package tech.aistar.day12.enums;

/**
 * 本类功能:性别枚举类型
 *
 * @author cxylk
 * @date 2020/8/5 20:09
 */
public class TestGender {
    public static void main(String[] args) {
        Student s1=new Student(1,"admin",Gender.F);

        System.out.println(s1);//Student{id=1, name='admin', gender=F}

        String ids="10";
        String name="admin";
        String sex="M";//这里的M不能换成汉字，否则会报java.lang.IllegalArgumentException

        //类型的转换操作
        Integer id=Integer.valueOf(ids);
        //重点就是要转换"F" -> 绑定到Gender枚举的实例F上

        //Gender gender=Enum.valueOf(Gender.class,sex);
        Gender gender=Enum.valueOf(Gender.class,sex);

        Student s2=new Student(id,name,gender);
        System.out.println(s2);
    }
}
