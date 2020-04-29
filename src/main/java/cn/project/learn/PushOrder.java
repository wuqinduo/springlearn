package cn.project.learn;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PushOrder {

    public static void generateOrderNo(){
        LocalDateTime now = LocalDateTime.now();


        System.out.println(now.format(DateTimeFormatter.ISO_DATE));
    }

    public static void main(String[] args) {
        generateOrderNo();
    }
}

/**
 * 1.订单号的生成规则：
 *          订单号16= 前8时间信息+6位自增序列+2位分库分表(0-99)
 *
 *          前8时间信息位：LocalDateTime
 *
 *          6位自增位：涉及到步长问题（为了保证全局序列号，此处不应跟随业务代码的回滚，将事务设置为开启新事务）此处想到50家系统的编码生成规则（1：一次生成多个2：当前序列号，一次生成多少）
 *
 *          分库分表位：Integer userId =1000122   = userId % 100
 *
 *2.扣减库存
 *
 *
 * public boolean subStock(){
 *      //扣减语句，只有有库存时才会扣减 update item_stock set stock = stock -#{amount} where item_id =  stock>=#{amount}
 *
 *      为啥有的要先取回库存数量呢？
 *
 *      int afterRow = daoMapper.subStock(stock,amount);
 *      if(afterRow>0){
 *          成功
 *      }
 * }
 *3.时间的使用：推荐：joad-time 或者 LocalDateTime
 * DateTime startDate;//joad-time 使用起来比较好
 *
 *
 *4.秒杀场景下：
 *      先插入购买记录，insert ignore record (userId,time) values("1",NOWE()) WHERE userId [主键冲突，返回0]
 *      再扣减库存
 *
 *  考虑的点：
 *      (1)尽量减少行级锁的持锁时间。插入秒杀记录，可能失败，就不用去扣减库存，就类似是否秒杀过的检查
 *      (2)尽量减少网络延迟，网络消耗。例如 lua脚本，存储过程(缺点业务绑定到了数据库)
 *
 * 5.安全性考虑：
 *
 *      悲观锁：sync
 *      乐观锁：带版本号更新。
 *
 * }
 */
