package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping(value = "/Access_Denied")
    public String getAccessDeniedPage() {
        return "access_denied";
    }
}
