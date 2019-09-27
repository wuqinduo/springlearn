package cn.wqd;

import cn.wqd.aop.AopController;
import cn.wqd.aop.LogAopTest;
import cn.wqd.aop.TransactionalTest;
import cn.wqd.beanlife.BeanUser;
import org.springframework.beans.BeanWrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"})
@Controller
public class SpringlearnApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringlearnApplication.class, args);
		AopController aopController = (AopController)context.getBean("aopController");
		aopController.sayHello("aop");
		TransactionalTest transactionalTest = (TransactionalTest)context.getBean("transactionalTest");
		transactionalTest.save();

//		BeanUser beanUser = (BeanUser) context.getBean("beanUser");
//		System.out.println("开始使用beanuser================");
//		beanUser.getName();
//		beanUser.getAddress();
//		System.out.println("停止使用beanuser================");
		//((AbstractApplicationContext) context).close();
	}
	@RequestMapping(value = "test")
	public void test(){

	}

}
