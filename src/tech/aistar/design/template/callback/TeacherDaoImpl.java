package tech.aistar.design.template.callback;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/31 19:50
 */
public class TeacherDaoImpl implements ITeacherDao{
    @Override
    public void find() {
        CallbackTemplate.execute(new ICallback() {
            @Override
            public void executeSql() {
                System.out.println("select * from teacher");
            }
        });
    }
}
