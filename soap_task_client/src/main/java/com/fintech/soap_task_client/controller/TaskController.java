package com.fintech.soap_task_client.controller;

import com.fintech.soap_task_client.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;

    @RequestMapping("/")
    public String all(Model model) {
        model.addAttribute("tasks", taskService.getAllTask());
        return "index";
    }
}
