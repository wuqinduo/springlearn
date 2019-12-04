package cn.wqd.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.util.Map;


@Service
public class TransactionalService {
    @Autowired
    DataSource dataSource;

    @Autowired
    UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String save(){
        System.out.println("被事务方法");
        User user = new User("被事务方法",1);
        //输出JDK动态代理产生的类
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        //输出CGLIB动态代理产生的类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./tran");
        Map<Object, Object> map = TransactionSynchronizationManager.getResourceMap();
        System.out.println(userDao.getClass().getName());//
        userDao.save(user);

        return "save";
    }

    public String noTransactionalSave(){
        System.out.println("非事务方法");
        return  save();
    }


    @Transactional
    public String save3(){
        System.out.println("掉事务方法");
        User user = new User("主动方事务方法",0);
        save();
        userDao.save(user);
        // System.out.println(1/0);
        return "1";
    }

    @Transactional
    public String save2(){
        System.out.println("掉事务方法");
        User user = new User("主动方事务方法",0);
        save();
        userDao.save(user);
       // System.out.println(1/0);
        return "1";
    }

    @Transactional
    public synchronized String  syncSave(){
        System.out.println("锁方法");
        User user = new User("锁方法",0);
        userDao.save(user);
        return "锁";
    }
}
