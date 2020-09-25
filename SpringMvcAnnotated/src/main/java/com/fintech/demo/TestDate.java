package com.fintech.demo;

import java.util.Date;

public class TestDate {
    private Date myDate;

    public TestDate() {
    }

    public TestDate(Date myDate) {
        this.myDate = myDate;
    }

    public Date getMyDate() {
        return myDate;
    }

    public void setMyDate(Date myDate) {
        this.myDate = myDate;
    }

    @Override
    public String toString() {
        return "TestDate{" +
                "myDate=" + myDate.toString() +
                '}';
    }
}
