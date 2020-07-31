package tech.aistar.design.template.callback;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/31 19:41
 */
public class StudentDaoImpl implements IStudentDao{
    @Override
    public void find() {
//        CallbackTemplate.execute(new ICallback() {
//            @Override
//            public void executeSql() {
//                System.out.println("select * from student;");
//            }
//        });
        //lambada写法
        CallbackTemplate.execute(() -> System.out.println("select * from students;"));
    }
}
