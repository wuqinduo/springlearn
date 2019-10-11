package cn.wqd.beanlife;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 2019/8/6.
 */
@Component
public class SmartLifecycleChild implements SmartLifecycle {



    @Override
    public int getPhase() {
        return 0;
    }

    @Override
    public void start() {
        System.out.println("SmartLifecycleChild 启动");
    }

    @Override
    public void stop() {
        System.out.println("SmartLifecycleChild 停止");
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable runnable) {

    }
}
