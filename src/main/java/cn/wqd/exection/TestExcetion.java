package cn.wqd.exection;

/**
 * Created by dell on 2019/9/6.
 */
public class TestExcetion {


    public static void main(String[] args) throws Exception{
        //check1();
        check2();
    }

    public static void check1() throws Exception{
        throw new MyServletExcetion("第一次校验错误");
    }

    public static void check2() {
        try {
            System.out.println(1/0);
        }catch (Exception e){
            throw new RuntimeException("第二次校验错误");
        }
    }
}
