package cn.project.learn;


import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * threadlocal应用场景
 */
public class ThreadLocalLearn {
}

class ThreadLocalLearn1 {
    private static final ThreadLocal threadsession = new ThreadLocal();

}

//Threadlocal在框架中的使用
class ThreadLocalLearnInFrame{
    //spring事务相关， 定义了一个事务同步器，来管理线程本地变量
    Object key_datasource;
    Object value_connectionHoler;
    private final SqlSessionFactory sqlSessionFactory =null;
    public void test(){
        TransactionSynchronizationManager.bindResource(key_datasource,value_connectionHoler);//将数据源与连接的映射绑定当前线程
        TransactionSynchronizationManager.getResource(key_datasource);//从线程变量中获取数值。
    }

    public void test2(){
        SqlSessionManager sqlSessionManager = SqlSessionManager.newInstance(sqlSessionFactory);
        sqlSessionManager.openSession();//放入共享变量
        sqlSessionManager.getConnection();//从线程本地变量取出
    }

}