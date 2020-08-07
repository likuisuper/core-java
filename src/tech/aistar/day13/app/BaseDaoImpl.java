package tech.aistar.day13.app;

/**
 * 本类功能:泛型实现类
 *
 * @author cxylk
 * @date 2020/8/7 18:45
 */
public class BaseDaoImpl<T> implements IBaseDao<T> {
    @Override
    public void save(T t) {
        //get - 所有的实现类的插入数据的步骤都是几乎是一样的
        //只是类型不一样而已..

        System.out.println("save:"+t);

//        Session ses = SessionUtil.openSession();//和db建立一次会话,一次连接.
//        Transaction transction = ses.beginTransaction();//开启使用.
//
//        //保存...
//        ses.save(t);//关键的一步...
//
//        //提交事务
//        transaction.commit();
//
//        //关闭session
//        sesssionUtil.close(ses);
    }

    @Override
    public void update(T t) {

    }

    @Override
    public void delById(Integer id) {

    }
}
