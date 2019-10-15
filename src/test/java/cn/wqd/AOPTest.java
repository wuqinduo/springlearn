package cn.wqd;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by dell on 2019/10/15.
 */
public class AOPTest {
    public static void main(String[] args) {
        //输出JDK动态代理
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        //输出CGLIB动态代理产生的类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./jdkproxy");
        //=============jdk代理
        User a=new User();
        //创建JDK代理
        JDKProxy jdkProxy=new JDKProxy(a);
        //创建代理对象
        UserInterface proxy=jdkProxy.createProxy();
        //执行代理对象方法
        proxy.doSomething();

        //=============CGLIB代理
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserNoInterface.class);
        enhancer.setCallback(new CglibProxyIntercepter());
        UserNoInterface proxyCGLB= (UserNoInterface)  enhancer.create();
        proxyCGLB.doSomething();

    }
}

//=========================jdk定义
interface UserInterface {
    void doSomething();
}

class User implements UserInterface {
    @Override
    public void doSomething() {
        System.out.println("我是实现了接口的User");
    }
}

class JDKProxy implements InvocationHandler {

    // 要被代理的目标对象
    private UserInterface target;

    public JDKProxy(UserInterface target){
        this.target=target;
    }
    public UserInterface createProxy(){
        return (UserInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK前置拦截");
        return method.invoke(target,args);
    }
}

//=========================cglb定义
class UserNoInterface{

    public void doSomething() {
        System.out.println("我是没有实现接口的User");
    }
}

class CglibProxyIntercepter implements MethodInterceptor {
    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行前...");
        Object object = methodProxy.invokeSuper(sub, objects);
        System.out.println("执行后...");
        return object;
    }
}