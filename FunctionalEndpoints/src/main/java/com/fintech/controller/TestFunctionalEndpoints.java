package com.fintech.controller;

import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

public class TestFunctionalEndpoints {

    public ServerResponse getIndex(ServerRequest serverRequest) {
        return ServerResponse.ok().render("func");
    }
}

