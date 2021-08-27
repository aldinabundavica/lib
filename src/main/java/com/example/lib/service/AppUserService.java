package com.example.lib.service;

import com.example.lib.jwt.JwtResponse;
import com.example.lib.jwt.JwtUtils;
import com.example.lib.model.AppUser;
import com.example.lib.model.MyUserDetails;
import com.example.lib.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AppUserService {

    @Autowired
    AppUserRepository _appUserRepository;

    @Autowired
    JwtUtils _jwtUtils;

    AuthenticationManager _authenticationManager;

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

    public ResponseEntity<?> generateAuthenticationToken(String username, String password) {
        Authentication authentication = _authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = _jwtUtils.generateJwtToken(authentication);

        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUsername()));
    }
}

