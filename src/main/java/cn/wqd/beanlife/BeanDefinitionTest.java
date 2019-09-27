package cn.wqd.beanlife;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * Created by dell on 2019/9/3.
 */
public class BeanDefinitionTest {

    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Test{name=" + name + '}';
    }


    public static void main(String[] args) {

        BeanWrapper wapper = new BeanWrapperImpl(BeanDefinitionTest.class);
        wapper.setPropertyValue("name","cest");
        System.out.println(wapper.getWrappedInstance());
        System.out.println(wapper.getPropertyValue("name"));
    }
}
