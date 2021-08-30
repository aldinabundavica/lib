package com.example.lib.service;

import com.example.lib.jwt.JwtResponse;
import com.example.lib.jwt.JwtUtils;
import com.example.lib.model.AppUser;
import com.example.lib.model.MyUserDetails;
import com.example.lib.model.Role;
import com.example.lib.model.RoleName;
import com.example.lib.repository.AppUserRepository;
import com.example.lib.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class AppUserService {

    @Autowired
    AppUserRepository _appUserRepository;

    @Autowired
    RoleRepository _roleRepository;

    @Autowired
    JwtUtils _jwtUtils;

    @Autowired
    AuthenticationManager _authenticationManager;

    public AppUser registerUser(AppUser user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        AppUser usr = null;

        if (_appUserRepository.existsByUsername(user.getUsername()) || _appUserRepository.existsByEmail(user.getEmail())) {
            return null;
        }
        try {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            Set roles = new HashSet<>();
            Role adminRole = _roleRepository.findByName(RoleName.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not found."));
            roles.add(adminRole);
            user.setRoles(roles);
            usr = _appUserRepository.save(user);
        }catch (Exception e){
            System.out.println(e);
            // TODO: 8/22/2021 logger
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
                userDetails.getUsername(), userDetails.getAuthorities()));
    }
}

