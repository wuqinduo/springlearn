package cn.codeDesign;

/**
 * Created by dell on 2020/8/24.
 */
public class Single {
    private static volatile Single single;
    public static Single getSingle(){
        if (single==null){
            synchronized (Single.class){
                if (single==null){
                    single=new Single();
                }
            }
        }
        return single;
    }

    public void  sayhello(){
        System.out.println("你好");
    }

    public static void main(String[] args) {
        Single single =  Single.getSingle();
        single.sayhello();
    }
}
