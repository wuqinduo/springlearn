package cn.wqd.checkes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2019/10/9.
 */
public class CheckTest {
    public static void main(String[] args) {
        CheckHandler checkHandler = new CompositeCheckHandler(getCheckHandlerForConfigurer());
        Object checkresult = checkHandler.check("refund");

    }

    //可以使用 责任链模式,或者 代理模式上加order排序,
    //策略模式针对的是单一的处理, 当需要多个处理的时候, 策略模式和代理模式都是不交好的.
    public static List<CheckHandler> getCheckHandlerForConfigurer(){
        List<CheckHandler> checkHandlers = new ArrayList<CheckHandler>();
        checkHandlers.add(new GiftCheckHandler());
        checkHandlers.add(new RefundCheckHandler());
        checkHandlers.add(new ParamCheckHandler());
        return checkHandlers;

    }
}
