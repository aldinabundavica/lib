package com.example.lib.controller;

import com.example.lib.helper.LoginRequest;
import com.example.lib.model.AppUser;
import com.example.lib.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MainController {
    @Autowired
    private AppUserService _appUserService;

    @PostMapping("/signin")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        return _appUserService.generateAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @PostMapping("/signup")
    public ResponseEntity<AppUser> processRegister(@RequestBody AppUser user) {
        try{
            return ResponseEntity.ok(_appUserService.registerUser(user));
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
