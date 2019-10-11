package cn.wqd.beanlife;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(ImportBeanTest.class)
@Configuration
public class MyBeanConfiguration {

    @Bean
    public ConfigurationBeanTest configurationBeanTest(){
        return new ConfigurationBeanTest();
    }
}
