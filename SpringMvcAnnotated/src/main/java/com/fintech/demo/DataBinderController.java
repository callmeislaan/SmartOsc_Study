package com.fintech.demo;

import com.fintech.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/databind")
public class DataBinderController {
    @Autowired
    private CompanyValidate companyValidate;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(companyValidate);
        DateFormatter dateFormatter = new DateFormatter();
        dateFormatter.setPattern("yyyy-MM-dd");
        binder.addCustomFormatter(dateFormatter, "dob");
        binder.registerCustomEditor(CreditCard.class, new CreditCardEditor());
    }

    @GetMapping
    public String getDataBindIndexPage(Model model) {
        model.addAttribute("company", new Company());
        return "data-bind-index";
    }

    @RequestMapping(value = "/doBinder", method = RequestMethod.POST)
    public String createCompany(@ModelAttribute("company") @Validated Company company,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "data-bind-index";
        }

        model.addAttribute("company", company);
        return "show-company";
    }

    @GetMapping("/addCredit")
    public String getCreditIndex() {
        return "credit-index";
    }

    @RequestMapping(value = "/addCredit", method = RequestMethod.POST)
    @ResponseBody
    public CreditCard addCredit(@RequestParam(value = "rawCardNumber") CreditCard creditCard) {
        return creditCard;
    }
}
