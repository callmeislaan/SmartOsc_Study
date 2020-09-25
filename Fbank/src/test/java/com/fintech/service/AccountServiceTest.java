package com.fintech.service;

import com.fintech.controller.AccountController;
import com.fintech.domain.Account;
import com.fintech.domain.AccountInfo;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountServiceTest extends Mockito {
    AccountService service = new AccountService();

    @Test
    public void itShouldCheckPasswordReturnTrue() {
        String name = "phuoc";
        String password = "123";
        assertTrue(service.checkPassword(name, password));
    }

    @Test
    public void itShouldRegisterReturnAccount() {
        Account account= new Account();
        account.setName("phuoc");
        account.setPassword("123");
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setFullName("hoang truong phuoc");
        accountInfo.setAddress("address");
        accountInfo.setEmail("email");
        accountInfo.setGender(1);
        accountInfo.setPhone("phone");
        account.setAccountInfo(accountInfo);
        Account accountResult = new AccountService().add(account);
        assertEquals(account.getName(), accountResult.getName());
    }
}
