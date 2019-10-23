package cn.wqd.aop;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TransactionalTest {
    public String save(){
        System.out.println("事务方法");
        return "save";
    }
}
