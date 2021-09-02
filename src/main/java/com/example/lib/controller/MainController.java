package com.example.lib.controller;

import com.example.lib.helper.LoginRequest;
import com.example.lib.model.AppUser;
import com.example.lib.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@CrossOrigin(origins="http://localhost:4200")
public class MainController {
    @Autowired
    private AppUserService _appUserService;

    @PostMapping("/signin")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
        return _appUserService.generateAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @PostMapping("/signup")
    public ResponseEntity<AppUser> processRegister(@Valid @RequestBody AppUser user) {
        return new ResponseEntity<AppUser>(_appUserService.registerUser(user), HttpStatus.CREATED);
    }
}
