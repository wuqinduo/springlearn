package cn.wqd.base;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("第一步：调用MyBeanFactoryPostProcessor的postProcessBeanFactory");
        BeanDefinition definition = configurableListableBeanFactory.getBeanDefinition("beanUser");
        MutablePropertyValues propertyValues = definition.getPropertyValues();
        if(propertyValues.contains("name")){
            propertyValues.addPropertyValue("name","在BeanFactoryPostProcessor中修改之后的备忘信息");
        }
    }
}
