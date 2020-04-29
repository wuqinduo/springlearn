package cn.project.learn;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayOrder {

    private Thread threadOrder;

    @PostConstruct
    public void init(){

    }

    @PreDestroy
    public void close(){

    }
}

class DlyOrderProcessor{
    public void initDelayOrder(){
        //从数据库获取数据库，重新计算时间放入延迟队列

    }
}

class ItemVo<T> implements Delayed{

    private long activeTime;
    private  T data;
    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}


/**
 *  mq来解决
 *  多个消费者，订单加入机器的ip?（初级）
 *
 */