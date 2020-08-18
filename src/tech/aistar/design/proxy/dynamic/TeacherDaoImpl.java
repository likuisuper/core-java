package tech.aistar.design.proxy.dynamic;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/18 20:34
 */
public class TeacherDaoImpl implements ITeacherDao {
    @Override
    public int find(int id) {
        System.out.println("find:"+id);
        return id;
    }

    @Override
    public void remove(int id) {
        System.out.println("id:"+id);
    }
}
