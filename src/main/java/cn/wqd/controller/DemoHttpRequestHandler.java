package cn.wqd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dell on 2020/1/8.
 */
//@Controller("/MyHttpRequestHandler")
public class DemoHttpRequestHandler implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("this my DemoHttpRequestHandler");
        response.getWriter().write("this my DemoHttpRequestHandler");
    }

}
