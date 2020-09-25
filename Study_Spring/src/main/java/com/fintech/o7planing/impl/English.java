package com.fintech.o7planing.impl;

import com.fintech.o7planing.lang.Language;

public class English implements Language {

    @Override
    public String getGreeting() {
        return "Hello";
    }

    @Override
    public String getBye() {
        return "Good bye";
    }
}
