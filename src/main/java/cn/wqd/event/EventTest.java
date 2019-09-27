package cn.wqd.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

/**
 * spring的事件机制
 */
public class EventTest {
    public static void main(String[] args) {
        ApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
    }

    public static  class HelloEvent extends ApplicationEvent{
        public HelloEvent(Object source) {
            super(source);
        }
    }
}
class SayHello implements ApplicationEventPublisher{
    @Override
    public void publishEvent(ApplicationEvent applicationEvent) {

    }

    @Override
    public void publishEvent(Object o) {

    }
}

