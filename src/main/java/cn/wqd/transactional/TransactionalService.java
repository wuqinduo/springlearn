package cn.wqd.transactional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TransactionalService {
    public String save(){
        System.out.println("事务方法");
        return "save";
    }
}
