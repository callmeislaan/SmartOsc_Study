package com.fintech.validation;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class MyValidation {
//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String propertyPath;
    private String message;

//    @Override
//    public String toString() {
//        return "MyValidation{" +
//                "propertyPath='" + propertyPath + '\'' +
//                ", message='" + message + '\'' +
//                '}';
//    }
}
