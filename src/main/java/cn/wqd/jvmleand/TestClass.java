package cn.wqd.jvmleand;

/**
 * Created by dell on 2020/3/18.
 */
public class TestClass {

    private String temp ;

    private static  String temp2;
    static {
        temp2 = "clinit方法";
    }

    public TestClass() {
        temp = "init()方法";
    }
    public String getFeilds(){
        return temp;
    }
}
