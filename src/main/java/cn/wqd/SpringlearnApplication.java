package cn.wqd;

import cn.wqd.aop.*;
import cn.wqd.beanlife.BeanTeacher;
import cn.wqd.beanlife.BeanUser;
import org.springframework.beans.BeanWrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"})
@Controller
public class SpringlearnApplication {

	public static void main(String[] args) {
		//输出JDK动态代理产生的类
		/*System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
		//输出CGLIB动态代理产生的类
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./cglbproxy");*/

		ApplicationContext context = SpringApplication.run(SpringlearnApplication.class, args);
		//CGLIB代理
		AopController aopController = (AopController)context.getBean("aopController");
		System.out.println(aopController.getClass().getName());
		aopController.sayHello("aop");
		//jdk代理
		AopControllerInterface aopControllerIml = (AopControllerInterface)context.getBean("aopControllerIml");
		System.out.println(aopControllerIml.getClass().getName());//打印jdk代理类的名，以便找到
		aopControllerIml.sayHello("JDK说aop");

		//事务
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

	@Bean
	public BeanTeacher beanTeacher(){
		System.out.println("创建一个teacher");
		return  new BeanTeacher();
	}

	private static boolean deleteAllByPath(File rootFilePath) {
		File[] needToDeleteFiles = rootFilePath.listFiles();
		if (needToDeleteFiles == null) {
			return true;
		}
		for (int i = 0; i < needToDeleteFiles.length; i++) {
			if (needToDeleteFiles[i].isDirectory()) {
				deleteAllByPath(needToDeleteFiles[i]);
			}
			try {
				Files.delete(needToDeleteFiles[i].toPath());
			} catch (IOException e) {
				return false;
			}
		}
		return true;
	}


}
