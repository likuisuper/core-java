package tech.aistar.day10.homework01;


/**
 * 本类功能:图书操作业务接口
 *
 * @author cxylk
 * @date 2020/7/31 20:04
 */
public interface IBookBiz {
    /**
     * 添加图书
     * @param b
     */
    void add(Book b);

    /**
     * 根据图书name来删除指定图书 - 不是唯一的,删除的是多个
     * @param name
     */
    void deleteByName(String name);

    /**
     * 根据id进行删除
     * @param id
     */
    void deleteById(int id);

    //打印所有图书信息
    void outputAllBooks();
}
