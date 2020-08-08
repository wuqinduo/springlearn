package cn.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;

/**
 * Created by dell on 2020/8/8.
 */
public class TestConnection {
    private static String remoteInetAddr = "192.168.21.213";//需要连接的IP地址
    public static void main(String[] args) {
        URL url = null;
        Boolean bon = false;
        try {
            url = new URL("http://baicu.com/");
            InputStream in = url.openStream();//打开到此 URL 的连接并返回一个用于从该连接读入的 InputStream
            System.out.println("连接正常");
            in.close();//关闭此输入流并释放与该流关联的所有系统资源。
        } catch (IOException e) {
            System.out.println("无法连接到：" + url.toString());
        }
        bon = isReachable(remoteInetAddr);
        System.out.println("pingIP：" + bon);
    }
    public static boolean isReachable(String remoteInetAddr) {
        boolean reachable = false;
        try {
            InetAddress address = InetAddress.getByName(remoteInetAddr);
            reachable = address.isReachable(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reachable;
    }
}
