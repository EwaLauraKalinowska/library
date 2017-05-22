package pl.ewa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.ewa.model.User;
import pl.ewa.service.UserService;

import java.util.List;

/**
 * Created by ewcia on 08.05.17.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsersPage(Model model){
        List <User> userList=userService.findAll();
        model.addAttribute("userList", userList);

        return "users";
    }

    @RequestMapping(value ="/create-user", method = RequestMethod.GET)
    public String getUserForm(){
        return "user-create";
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public String saveUser(@RequestParam(required = false) Long id,
                           @RequestParam(name = "firstName", required = true) String firstName,
                           @RequestParam(name = "lastName", required =true )String lastName,
                           @RequestParam(name ="password" , required = true) String password,
                           @RequestParam(name = "email", required = true)String email){

        User user = new User(firstName, lastName, email, password);
        userService.save(user);

        return "redirect:/users";
    }

    @RequestMapping(value = "/delete/user/{id}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable Long id){

        userService.delete(id);

        return "redirect:/users";
    }

    @RequestMapping(value = "/edit/user/{id}", method = RequestMethod.POST)
    public String getEditUser(@PathVariable Long id, Model model){

        User user=userService.findOne(id);
        model.addAttribute("user", user);

        return "user-create";
    }
}
