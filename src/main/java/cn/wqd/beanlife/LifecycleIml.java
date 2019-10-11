package cn.wqd.beanlife;


import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 2019/8/6.
 */
@Service
public class LifecycleIml implements Lifecycle {

    @Override
    public void start() {
        System.out.println("Lifecycle 启动");
    }

    @Override
    public void stop() {
        System.out.println("Lifecycle 停止");
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
