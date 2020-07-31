package tech.aistar.design.template.callback;

/**
 * 本类功能:测试类
 *
 * @author cxylk
 * @date 2020/7/31 19:51
 */
public class TestCallback {
    public static void main(String[] args) {
        IStudentDao studentDao=new StudentDaoImpl();
        studentDao.find();

        System.out.println("=========");

        ITeacherDao teacherDao=new TeacherDaoImpl();
        teacherDao.find();
    }
}
