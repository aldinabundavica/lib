package com.example.lib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import com.javainspires.demothymeleaf.form.LoginForm;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String viewLoginPage() {
        // custom logic before showing login page...

        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "loginForm") LoginForm loginFom, Model model) {

    }

    @GetMapping("/home")
    public String home(@RequestParam(required = false) String login, Model model) {
        model.addAttribute("login", login);
        return "index";
    }
}
