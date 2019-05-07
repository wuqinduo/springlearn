package cn.wqd.base;

import com.sun.istack.internal.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("beanUser")){
            System.out.println("第六步：BeanPostProcessor，对象" + beanName + "调用初始化方法(包含哪些？？)之前的数据： " + bean.toString());
        }
        return bean;
    }

    @Override
    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("beanUser")){
            System.out.println("第九步：BeanPostProcessor，对象" + beanName + "调用初始化方法之后的数据：" + bean.toString());
        }
        return bean;
    }
}
