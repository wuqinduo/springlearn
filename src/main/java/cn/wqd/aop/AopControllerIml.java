package cn.wqd.aop;

import org.springframework.stereotype.Service;

/**
 * Created by dell on 2019/10/15.
 */
@Service
public class AopControllerIml implements AopControllerInterface{
    @Override
    public String sayHello(String name) {
        System.out.println("JDK动态代理");
        return null;
    }
}
