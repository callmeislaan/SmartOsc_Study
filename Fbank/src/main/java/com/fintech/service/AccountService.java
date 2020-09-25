package com.fintech.service;

import com.fintech.dao.AccountDAO;
import com.fintech.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountDAO accountDAO;

    public Account selectAccountByName(String name) {
        return accountDAO.selectAccountByName(name)
                .orElseThrow(() -> new AccountException("select by name field!"));
    }

    public boolean checkPassword(String name, String password) {
        String passwordTrue = accountDAO.selectPasswordByName(name)
                .orElseThrow(() -> new AccountException("select by name field!"));
        return passwordTrue.equals(password);
    }

    private void checkActive(Account account) {
        Account.Status BLOCK = Account.Status.BLOCK;
        if (Account.Status.getStatusByValue(account.getStatus()).equals(BLOCK))
            updateTimeBlock(account);
    }

    void updateTimeBlock(Account account) {
        if (account.getTimeBlock().isBefore(LocalDateTime.now())) {
            account.setLoginFielded(0);
            account.setStatus(Account.Status.ACTIVE.getCode());
        }
    }

    public Account checkLogin(String userName, String password) {
        Account account = accountDAO.selectAccountByName(userName.trim()).orElse(null);
        if (account != null) {
            if (account.isMatchPassword(password)) {
                checkActive(account);
            } else {
                checkToSetTimeBlock(account);
            }
        }
        return account;
    }

    void checkToSetTimeBlock(Account account) {
        Integer loginFielded = account.getLoginFielded();
        account.setLoginFielded(loginFielded + 1);
        if (account.getLoginFielded() >= 5) {
            account.setStatus(Account.Status.BLOCK.getCode());
            account.setTimeBlock(LocalDateTime.now()
                    .plus(2, ChronoUnit.MINUTES));
        }
    }

    public Account add(Account account) {
        return accountDAO.add(account).orElse(null);
    }

    public static class AccountException extends RuntimeException {
        public AccountException(String message) {
            super(message);
        }
    }
}
