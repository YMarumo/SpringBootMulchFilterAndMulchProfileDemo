package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.authentication.UserAuthentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/aaa")
public class UserAController {

    @GetMapping("/name")
    public String getName() {
        UserAuthentication userAuthentication = (UserAuthentication) SecurityContextHolder.getContext().getAuthentication();
        return userAuthentication.getAuthorityString();
    }
    
}
