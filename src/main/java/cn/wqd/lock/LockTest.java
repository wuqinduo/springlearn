package cn.wqd.lock;

import cn.wqd.transactional.UserDao;
import org.apache.ibatis.binding.MapperProxyFactory;

import java.util.concurrent.locks.Lock;

/**
 * Created by dell on 2019/12/25.
 */
public class LockTest {

    private static  Object lock = new Object();

    public static void main(String[] args) {
        new MapperProxyFactory<>(UserDao.class);
        System.out.println("test");
        synchronized (lock){
            System.out.println("test");
        }
    }
}
