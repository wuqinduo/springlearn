package cn.wqd.beanlife;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by dell on 2019/9/3.
 */
public class RunTest  {

    public static void main(String[] args) {
        Date date = new Date();//获取当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND,-10);
        Date date1 =calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println( sdf.format(date));;
        System.out.println(sdf.format(date1));;
    }
}
