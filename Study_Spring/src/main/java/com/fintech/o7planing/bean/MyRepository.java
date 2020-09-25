package com.fintech.o7planing.bean;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class MyRepository {
    public String getAppName() {
        return "Hello Spring App";
    }

    public Date getSystemDateTime() {
        return new Date();
    }
}
