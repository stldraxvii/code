package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Matt on 6/5/2017.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add", method=RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new User());
        return ("user/add");
    }

    @RequestMapping(value = "add", method=RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors errors, @RequestParam String verify) {
        if (errors.hasErrors()) {
            model.addAttribute(user);
            return ("user/add");
        }
        String errorMessage;
        String password = user.getPassword();
        if (password != null && verify != null) {
            if (password.equals(verify)) {
                model.addAttribute("name", user.getUsername());
                return ("user/index");
            } else {
                errorMessage = "Please make sure passwords match.";
                user.setPassword("");
                model.addAttribute("errorMessage",errorMessage);
                return ("user/add");
            }
        } else {
            errorMessage = "Please enter values in both password fields.";
            user.setPassword("");
            model.addAttribute("errorMessage",errorMessage);
            return ("user/add");
        }
    }
}
