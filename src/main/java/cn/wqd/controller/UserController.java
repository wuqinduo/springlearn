package cn.wqd.controller;


import cn.wqd.transactional.TransactionalService;
import cn.wqd.transactional.User;
import cn.wqd.transactional.UserDao;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController implements ApplicationContextAware{

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context  =applicationContext;
    }

    @RequestMapping("/test")
    public void test(){
        TransactionalService transactionalService = (TransactionalService)context.getBean("transactionalService");
        UserDao userDao = (UserDao) context.getBean("userDao");
        System.out.println(userDao.getClass().getName());
        //transactionalService.save();//只调用事务方法*/
        //transactionalService.noTransactionalSave();//非事务方法调用事务帆帆
        transactionalService.save2();//事务方法调用事务方法
    }

    @RequestMapping("/get")
    public Object get(){
        UserDao userDao = (UserDao) context.getBean("userDao");
        User userlist = userDao.getById("51");
        return userlist;
    }
}
