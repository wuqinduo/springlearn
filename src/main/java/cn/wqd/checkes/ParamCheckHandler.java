package cn.wqd.checkes;

/**
 * Created by dell on 2019/10/9.
 */
public class ParamCheckHandler implements CheckHandler{
    @Override
    public Object check(String param) {
        if("param".equals(param)){
            return "param 检查失败";
        }else {
            System.out.println("参数检查通过");
            return null;
        }
    }
}
