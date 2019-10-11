package cn.wqd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/handlerMapping")

public class HandlerMappingTest {
    @RequestMapping("/test")
    public void getHandlerMappingTest(){
        System.out.println("ssssssssss");
    }
}
