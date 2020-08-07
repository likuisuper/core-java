package tech.aistar.day13.app;

import tech.aistar.day07.User;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/7 18:48
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao{
    @Override
    public void findUser() {
        System.out.println("findUser...");
    }
}
