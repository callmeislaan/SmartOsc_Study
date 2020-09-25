package com.fintech.demo;

import com.fintech.entity.Company;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

public class StringToObjectConverter implements ConverterFactory<String, Company> {
    @Override
    public <T extends Company> Converter<String, T> getConverter(Class<T> targetType) {
        return null;
    }
}
