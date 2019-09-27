package cn.wqd.submethod;

/**
 * Created by dell on 2019/8/15.
 */
public class MyGenericWebApplicationContext extends  MyGenericApplicationContext{

    protected void postProcessBeanFactory(){
        System.out.println("postProcessBeanFactory2");
    }
}
