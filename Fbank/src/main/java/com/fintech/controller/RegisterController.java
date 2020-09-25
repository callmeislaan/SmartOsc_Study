package com.fintech.controller;

import com.fintech.domain.Account;
import com.fintech.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterView(Model model) {
        model.addAttribute("account", new Account());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("account") Account account, Model model,
                             RedirectAttributes redirectAttributes) {
//        model.addAttribute("account", accountService.add(account));
        redirectAttributes.addFlashAttribute("account", accountService.add(account));
        return "redirect:/account-info";
    }

    @RequestMapping(value = "/account-info")
    public String doRegisterSuccess() {
        return "account-info";
    }

}
