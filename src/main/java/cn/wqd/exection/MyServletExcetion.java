package cn.wqd.exection;

/**
 * Created by dell on 2019/9/6.
 */
public class MyServletExcetion extends Exception{
    public MyServletExcetion() {
    }

    public MyServletExcetion(String message) {
        super(message);
    }

    public MyServletExcetion(String message, Throwable cause) {
        super(message, cause);
    }
}
