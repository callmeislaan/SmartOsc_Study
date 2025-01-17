package com.fintech.demo;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

public class CreditCardEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        CreditCard creditCard = (CreditCard) getValue();
        return creditCard == null ? "" : creditCard.getRawCardNumber();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isEmpty(text)) {
            setValue(null);
        } else {
            CreditCard creditCard = new CreditCard();
            creditCard.setRawCardNumber(text);

            String cardNo = text.replaceAll("-", "");
            if (cardNo.length() != 16)
                throw new IllegalArgumentException("Credit card format should be xxxx-xxxx-xxxx-xxxx");
            creditCard.setBankIdNo(Integer.valueOf(cardNo.substring(0, 6)));
            creditCard.setAccountNo(Integer.valueOf(cardNo.substring(6, cardNo.length() - 1)));
            creditCard.setCheckCode(Integer.valueOf(cardNo.substring(cardNo.length() - 1)));
            setValue(creditCard);
        }
    }
}
