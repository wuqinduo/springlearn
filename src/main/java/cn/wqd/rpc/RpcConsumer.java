package cn.wqd.rpc;

/**
 * Created by dell on 2020/5/22.
 */
public class RpcConsumer {
    public static void main(String[] args) throws Exception {
        //代理类实例引用
        HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);
        for (int i = 0; i < Integer.MAX_VALUE; i ++) {
            String hello = service.hello("World" + i);
            System.out.println(hello);
            Thread.sleep(1000);
        }
    }
}
