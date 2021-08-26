package com.example.lib.service;

import com.example.lib.model.AppUser;
import com.example.lib.model.MyUserDetails;
import com.example.lib.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AppUserService {

    @Autowired
    AppUserRepository _appUserRepository;
    @Autowired
    MyUserDetailsService _myUserDetailsService;

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

    private void authenticate(String email, String password) throws Exception {
        Objects.requireNonNull(email);
        Objects.requireNonNull(password);
        try {
           // authenticationManager.authenticate(new EmailPasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    public ResponseEntity<?> generateAuthenticationToken(String email, String password) {
      //  authenticate(email, password);

      //  final UserDetails userDetails = loadUserByUsername(email);

        //final String token = jwtTokenUtil.generateToken(userDetails);

        return null; //ResponseEntity.ok(); //new JwtResponse(token));
    }
}

