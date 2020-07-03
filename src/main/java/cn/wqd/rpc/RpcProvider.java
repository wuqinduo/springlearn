package cn.wqd.rpc;

/**
 * Created by dell on 2020/5/22.
 */
public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService  service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
