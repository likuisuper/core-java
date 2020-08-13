package tech.aistar.day15.prj;



import tech.aistar.day15.io.Book;

import java.util.List;

/**
 * 本类功能:业务接口 - 把文件当成数据库来使用
 *
 * @author cxylk
 * @date 2020/8/12 12:51
 */
public interface IBookDao {
    /**
     * 读取所有的图书信息
     * //1.文件不存在...
     * //2.文件中没有内容...
     * //3.文件中不是合法的流...
     *
     * //统一返回null
     * @return
     */
    List<Book> findAll();

    /**
     * 根据图书的Id来删除图书
     * @param id
     */
    void delById(int id);

    /**
     * 保存的思路：
     * 后面每次写入之前，先来读取操作 - List集合中 - 加入b - 一次性将List全部写进去
     * @param b
     */
    void save(Book b);
}
