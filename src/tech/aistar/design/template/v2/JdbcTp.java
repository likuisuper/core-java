package tech.aistar.design.template.v2;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/31 13:01
 */
public abstract class JdbcTp {

    public final void execute(){
        System.out.println("1.加载驱动");
        System.out.println("2.连接DB");

        //获取数据
        //每次获取的数据可能是不一样的 - 延迟到子类中去实现
        executeSql();

        System.out.println("关闭连接");
    }

    public abstract void executeSql();
}

//会产生很多多余的子类
class JdbcSub01 extends JdbcTp{

    @Override
    public void executeSql() {
        System.out.println("select * from student");
    }
}

class TestSub01{
    public static void main(String[] args) {
        JdbcTp s=new JdbcSub01();
        s.execute();
        System.out.println("=====");

//        JdbcTp s2=new JdbcTp() {//匿名内部类
//            @Override
//            public void executeSql() {
//                System.out.println("select * from teacher");
//            }
//        };
//        s2.execute();

//        JdbcTp s2=new JdbcTp() {
//            @Override
//            public void executeSql() {
//                System.out.println("select * from teacher");
//            }
//        };
//        s2.execute();


        System.out.println("====");

//        new JdbcTp() {
//            @Override
//            public void executeSql() {
//                System.out.println("select * from course");
//            }
//        }.execute();

//        new JdbcTp(){
//
//            @Override
//            public void executeSql() {
//                System.out.println("select * from course");
//            }
//        }.execute();

        new JdbcTp(){

            @Override
            public void executeSql() {
                System.out.println("select * from course");
            }
        }.execute();
    }
}
