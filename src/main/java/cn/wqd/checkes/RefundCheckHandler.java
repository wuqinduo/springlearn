package cn.wqd.checkes;

/**
 * Created by dell on 2019/10/9.
 */
public class RefundCheckHandler implements CheckHandler {
    @Override
    public Object check(String param) {
        if("refund".equals(param)){
            return "不能全部退回";
        }else {
            System.out.println("退款校验通过");
            return null;
        }
    }
}
