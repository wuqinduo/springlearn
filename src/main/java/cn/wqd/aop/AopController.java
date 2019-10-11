package cn.wqd.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dell on 2019/9/24.
 */
@RestController
@RequestMapping("/aopController")
public class AopController {
    @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
    public String sayHello(String name){
        return "hello " + name;
    }
}
