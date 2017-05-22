package pl.ewa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.ewa.service.EmailService;
import pl.ewa.service.UserService;

/**
 * Created by ewcia on 08.05.17.
 */

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/")
    public String getMainPage(){
        return "home";
    }

    @RequestMapping(value = "/login")
    public String getLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/register")
    public String getRegisterPage(){
        return "register";
    }
}
