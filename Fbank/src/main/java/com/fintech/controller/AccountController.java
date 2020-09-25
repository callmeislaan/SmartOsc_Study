package com.fintech.controller;

import com.fintech.domain.Account;
import com.fintech.service.AccountService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.filter.FormContentFilter;
import sun.plugin2.message.GetAppletMessage;

import javax.servlet.ServletRequest;
import java.time.Duration;
import java.time.LocalDateTime;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model) {

        Account account = accountService.checkLogin(name, password);

        if (!account.isMatchPassword(password)) {
            return "login-error";
        } else {
            if (account.getStatus().equals(Account.Status.BLOCK.getCode())) {
                double remainingTime = Duration.between(LocalDateTime.now(), account.getTimeBlock()).getSeconds() / 60.;
                model.addAttribute("remainingTime", remainingTime);
                return "account-block";
            } else {
                return "home";
            }
        }
    }

}
