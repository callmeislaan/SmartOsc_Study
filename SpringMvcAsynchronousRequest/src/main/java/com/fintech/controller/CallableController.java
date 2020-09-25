package com.fintech.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

@Controller
public class CallableController {
    private static final Logger LOGGER = Logger.getLogger(CallableController.class);

    @RequestMapping("callable")
    @ResponseBody
    public Callable<String> handleTestRequest() {
        LOGGER.info("handler started");

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                LOGGER.info("async task started");
                Thread.sleep(2*1000);
                LOGGER.info("async task finished");
                return "async result";
            }
        };

        LOGGER.info("handler finished");
        return callable;
    }
}
