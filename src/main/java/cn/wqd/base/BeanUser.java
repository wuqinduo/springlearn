package cn.wqd.base;

import org.springframework.beans.factory.InitializingBean;

/**
 * bean生命周期:
 * https://blog.csdn.net/zhanyu1/article/details/83114684
 * https://www.cnblogs.com/april-chen/p/8182631.html
 */
public class BeanUser implements InitializingBean{

    private String name;

    private String address;

    public BeanUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    public void  initMethod(){

    }
}
