package cn.wqd.rpc;

/**
 * Created by dell on 2020/5/22.
 */
public class HelloServiceImpl implements HelloService{

    public String hello(String name) {
        return "Hello " + name;
    }

}
