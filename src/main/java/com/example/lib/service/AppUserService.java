package com.example.lib.service;

import com.example.lib.model.AppUser;
import com.example.lib.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    AppUserRepository _appUserRepository;

    public AppUser registerUser(AppUser user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        AppUser usr = null;
        try {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            usr = _appUserRepository.save(user);
        }catch (Exception e){
            System.out.println(e);
            // TODO: 8/22/2021 logger npr
        }
        return usr;
    }
}
