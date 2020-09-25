package com.fintech.demo;

import com.fintech.entity.Company;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CompanyValidate implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Company.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Company company = (Company) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "","id is empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "","name is empty");
        if (company.getName().length() < 5) {
            errors.rejectValue("name", "", "name length is less than 5");
        }
    }
}
