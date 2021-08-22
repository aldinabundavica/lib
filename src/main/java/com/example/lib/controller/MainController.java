package com.example.lib.controller;

import com.example.lib.model.AppUser;
import com.example.lib.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @Autowired
    private AppUserService _appUserService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new AppUser());
        return "register";
    }

    @PostMapping("/process_register")
    public String processRegister(AppUser user) {
        AppUser usr = _appUserService.registerUser(user);
        if(usr != null)
            return "redirect:/home";

        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home() {
        return "index";
    }

}
