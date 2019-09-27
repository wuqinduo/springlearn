package cn.wqd.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * bean生命周期:
 * https://blog.csdn.net/zhanyu1/article/details/83114684
 * https://www.cnblogs.com/april-chen/p/8182631.html
 * https://blog.csdn.net/geekjoker/article/details/79868945
 */
@Component
@Lazy(value = true)
public class BeanUser implements InitializingBean, ApplicationContextAware, DisposableBean {

    private String name;

    private String address;

    public BeanUser() {
        System.out.println("第二步：执行bean的无参构造函数");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("第三步：对象初始化设置属性setName");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("第四步：对象初始化设置属性setAddress");
        this.address = address;
    }

    public void  initMethod(){
        System.out.println("第八步：指定了initMethod===》调用initMethod方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("第五步：处理各种aware，此处处理的是ApplicationContextAware");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第七步：实现InitializingBean接口===》调用afterPropertiesSet方法");
    }

    public void destroyMethod(){
        System.out.println("第十一步：指定destroy-method，执行destroy-method方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("第十步：实现DisposableBean，执行destroy()方法");
    }
}
