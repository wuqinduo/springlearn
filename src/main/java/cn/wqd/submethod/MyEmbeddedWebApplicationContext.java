package cn.wqd.submethod;

/**
 * Created by dell on 2019/8/15.
 */
public class MyEmbeddedWebApplicationContext extends MyGenericWebApplicationContext{

    protected void postProcessBeanFactory(){
        System.out.println("postProcessBeanFactory3");
    }
}
