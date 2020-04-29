package cn.project.learn;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class SmsChooser implements ApplicationContextAware {

    private Map<String,SmsService> chooseMap = new ConcurrentHashMap<>();

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            context =applicationContext;
    }

    @PostConstruct
    public void inintChooser(){
        Map<String,SmsService> beanMap = context.getBeansOfType(SmsService.class);
        beanMap.forEach((String t, SmsService u) ->{
            chooseMap.put(t,u);
        });

    }
}

interface SmsService{

}

