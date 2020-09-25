package com.fintech.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDemoLog4jServlet extends Mockito {
    @Test
    public void itShouldShowLogInConsole() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
//        DemoLog4jServlet demoLog4jServlet = new DemoLog4jServlet();

        ApplicationContext context
//                = new AnnotationConfigApplicationContext("com.fintech");
                = new ClassPathXmlApplicationContext("bean.xml");
        DemoLog4jServlet demoLog4jServlet = context.getBean("demo", DemoLog4jServlet.class);

        demoLog4jServlet.doGet(request, response);
        String messenger = "i fall in love with you";
        String path = "D:\\Java\\DemoLog4j\\src\\main\\resources\\logging.log";
        BufferedReader br =
                new BufferedReader(new FileReader(path));
        String actualMessenger = br.readLine();
        assertTrue(actualMessenger.contains(messenger));
    }
}
