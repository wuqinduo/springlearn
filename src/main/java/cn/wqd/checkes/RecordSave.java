package cn.wqd.checkes;

import java.util.LinkedHashMap;

/**
 * Created by dell on 2019/10/9.
 */
public class RecordSave {

    public Object save(){
        LinkedHashMap reulst = new LinkedHashMap();
        if(!isGiftRefund()){
            reulst.put("code","9999");
            reulst.put("message","礼物没有退回");
            return reulst;
        }

        if(!isRefund90()){
            reulst.put("code","9999");
            reulst.put("message","退款超过90%,没有走审核,请先走审核");
        }

        return "success";
    }

    public boolean isGiftRefund(){
        return false;
    }

    public boolean isRefund90(){
        return true;
    }
}
