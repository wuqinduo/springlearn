package cn.wqd.submethod;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by dell on 2019/8/15.
 */
public abstract class MyAbstractApplicationContext {
    public void refresh() {
        postProcessBeanFactory();
    }

    protected void postProcessBeanFactory() {
        System.out.println("postProcessBeanFactory1");
    }
}
