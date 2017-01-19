package ru.fnregistry.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.Calendar;

import static ru.fnregistry.app.service.user.UserServiceImpl.getUserId;
import static ru.fnregistry.app.service.user.UserServiceImpl.getUsername;

@RequestMapping("/")
@Controller
public class WelcomeController {

    @RequestMapping("")
    public String index() {
        return "redirect:welcome";
    }

    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("username", getUsername());
        return "index";
    }
}
