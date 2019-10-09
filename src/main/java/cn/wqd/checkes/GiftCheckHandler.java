package cn.wqd.checkes;

/**
 * Created by dell on 2019/10/9.
 */
public class GiftCheckHandler implements CheckHandler{
    @Override
    public Object check(String param) {
        if("gift".equals(param)){
            return "礼品未全部退回";
        }else {
            System.out.println("礼品校验通过");
            return null;
        }
    }
}
