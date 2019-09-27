package cn.wqd.aop;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogAopTest {
    @GetMapping("/aoptest")
    public String getName(String name){
        System.out.println("dddddddddddd");
        return  "ddddddddddd";
    }
}
