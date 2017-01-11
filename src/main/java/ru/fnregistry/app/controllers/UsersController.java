package ru.fnregistry.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.fnregistry.app.repository.UserRepository;
import ru.fnregistry.app.service.user.UserService;

@Controller
public class UsersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsersList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        LOGGER.debug("Getting users page");
        return "users";
    }
}


//package ru.fnregistry.app.controllers;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//import ru.fnregistry.app.service.user.UserService;
//
//@Controller
//public class UsersController {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);
//    private final UserService userService;
//
//    @Autowired
//    public UsersController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @RequestMapping("/users")
//    public ModelAndView getUsersPage() {
//        LOGGER.debug("Getting users page");
//        return new ModelAndView("users", "users", userService.getAllUsers());
//    }
//
//}
