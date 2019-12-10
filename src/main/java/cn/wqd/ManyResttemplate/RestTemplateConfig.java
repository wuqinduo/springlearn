package cn.wqd.ManyResttemplate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 可以配置三种resttemplate 。
 */
@Component
public class RestTemplateConfig {

    //带有权限的，负载均衡的restTemplate
    /*@LoadBalanced
    @Qualifier(value = "OAuthLoadBalancedRestTemplate")
    @Bean
    public OAuth2RestTemplate loadBalancedOauth2RestTemplate(
            OAuth2ProtectedResourceDetails resource, OAuth2ClientContext context) {
        return new OAuth2RestTemplate(resource, context);
    }*/

    //带负载均衡的restTemplate
   /* @LoadBalanced
    @Qualifier(value = "BalancedRestRestTemplate")
    @Bean
    public RestTemplate loadBalancedRestTemplate(
            OAuth2ProtectedResourceDetails resource, OAuth2ClientContext context) {
        return new RestTemplate();
    }*/

    //普通template
    @Qualifier(value = "RestTemplate")
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
