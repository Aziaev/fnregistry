package ru.fnregistry.app.controllers;

import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.fnregistry.app.domain.User;
import ru.fnregistry.app.repository.UserRepository;
import ru.fnregistry.app.service.messages.SOAPHelper;
import ru.fnregistry.app.service.user.UserService;

import java.math.BigInteger;


@Controller
public class UsersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);
    private final UserService userService;

    @Autowired
    private UserRepository repository;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsersList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("usersAndRequests", repository.findAll());
        LOGGER.debug("Getting users page");
        return "users";
    }

    @RequestMapping(value = "users/request/{id}", method = RequestMethod.GET)
    public ModelAndView sendRequest(@PathVariable long id) {

        SOAPHelper soapHelper = new SOAPHelper();
        soapHelper.SOAPSendAndGetRequest(repository.findOne(id).getId(), repository);

        return new ModelAndView("redirect:/users/");
    }

    @RequestMapping(value = "users/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
        repository.delete(id);
        return new ModelAndView("redirect:/users/");
    }

    @RequestMapping(value = "users/{id}/clear", method = RequestMethod.GET)
    public ModelAndView clear(@PathVariable long id) {
        User user = repository.findOne(id);
        user.setStatus(60);
        user.setTin("0");
        user.setRequestId(BigInteger.valueOf(0));
        user.setRequestCode(0);
        repository.save(user);
        return new ModelAndView("redirect:/users/");
    }

    @RequestMapping(value = "users/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable long id,
                       Model model) {
        User user = repository.findOne(id);
        //Attributes for default values
        model.addAttribute("id", user.getId());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("surname", user.getSurname());
        model.addAttribute("firstname", user.getFirstname());
        model.addAttribute("patronymic", user.getPatronymic());
        model.addAttribute("birthdate", user.getBirthdate());
        model.addAttribute("user", user);
        return "edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("id") long id,
                               @RequestParam("email") String email,
                               @RequestParam("surname") String surname,
                               @RequestParam("firstname") String firstname,
                               @RequestParam("patronymic") String patronymic,
                               @RequestParam("birthdate") String birthdate) {
        User user = repository.findOne(id);
        user.setEmail(email);
        user.setSurname(surname);
        user.setFirstname(firstname);
        user.setPatronymic(patronymic);
        user.setBirthdate(birthdate);

        user.setStatus(60);
        user.setTin("0");
        user.setRequestId(BigInteger.valueOf(0));
        user.setRequestCode(0);
        repository.save(user);
        return new ModelAndView("redirect:/users");
    }
}