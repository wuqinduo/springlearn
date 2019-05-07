package cn.wqd;

import cn.wqd.base.BeanUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"})
public class SpringlearnApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringlearnApplication.class, args);
		BeanUser beanUser = (BeanUser) context.getBean("beanUser");
		System.out.println("开始使用beanuser================");
		beanUser.getName();
		beanUser.getAddress();
		System.out.println("停止使用beanuser================");
		((AbstractApplicationContext) context).close();

	}

}
