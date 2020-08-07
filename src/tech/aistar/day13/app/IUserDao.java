package tech.aistar.day13.app;

import tech.aistar.day07.User;

/**
 * 本类功能:user的接口
 *
 * @author cxylk
 * @date 2020/8/7 18:44
 */
public interface IUserDao extends IBaseDao<User>{
    //只要定义特有的方法
    void findUser();
}
