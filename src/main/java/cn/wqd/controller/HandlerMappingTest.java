package cn.wqd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/handlerMapping")
@RestController
@Controller("/handler")
public class HandlerMappingTest {
    @RequestMapping("/testhandler")
    public String getHandlerMappingTest(HttpServletRequest request, HttpServletResponse response){
        request.getParameter("a");
        System.out.println(request.getParameterValues("name"));
        System.out.println("ssssssssss");
        return "sdsfsdf";
    }

    @PostMapping("/post/{id}/{name}")
    public void Post(@PathVariable(value = "id") String id,@PathVariable(value = "name") String name, HttpServletRequest request, HttpServletResponse response){
        String value = request.getParameter("post");
        System.out.println(value);
    }
}
