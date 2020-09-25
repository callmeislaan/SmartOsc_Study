package com.fintech.o7planing.impl;

import com.fintech.o7planing.lang.Language;

public class Vietnamese implements Language {
    @Override
    public String getGreeting() {
        return "Xin chào";
    }

    @Override
    public String getBye() {
        return "Tạm biệt";
    }
}
