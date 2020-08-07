package tech.aistar.day13.app;

/**
 * 本类功能:顶级的业务接口
 *
 * @author cxylk
 * @date 2020/8/7 18:41
 */
public interface IBaseDao<T> {
    void save(T t);

    void update(T t);

    void delById(Integer id);
}
