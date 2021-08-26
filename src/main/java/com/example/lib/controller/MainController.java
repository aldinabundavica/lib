package com.example.lib.controller;

import com.example.lib.model.AppUser;
import com.example.lib.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MainController {
    @Autowired
    private AppUserService _appUserService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "login";
    }

    @GetMapping("/register")
    public String register(@RequestBody AppUser user) {

        return "register";
    }

    @PostMapping("/signup")
    public ResponseEntity<AppUser> processRegister(@RequestBody AppUser user) {
        try{
            return ResponseEntity.ok(_appUserService.registerUser(user));
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/home")
    public String home() {
        return "index";
    }

}
