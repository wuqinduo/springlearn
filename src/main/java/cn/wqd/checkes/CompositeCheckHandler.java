package cn.wqd.checkes;

import java.util.List;

/**
 * 代理校验类,
 */
public class CompositeCheckHandler implements CheckHandler{
    private final List<CheckHandler> checkHandlerList;

    public CompositeCheckHandler(List<CheckHandler> checkHandlerList) {
        this.checkHandlerList = checkHandlerList;
    }

    @Override
    public Object check(String param) {
        for (CheckHandler checkHandler :checkHandlerList){
            Object checkResult = checkHandler.check(param);
            if(checkResult!=null){
                System.out.println(checkResult);
                System.out.println("检验失败,提示前台检查错误信息");
                return checkResult;
            }
        }
        return null;
    }

    public void addCheckHandler(CheckHandler checkHandler){
        checkHandlerList.add(checkHandler);
    }
}
