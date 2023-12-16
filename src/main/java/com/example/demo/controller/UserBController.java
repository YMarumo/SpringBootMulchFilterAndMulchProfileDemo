package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bbb")
public class UserBController {
    @GetMapping("/name")
    public String getName() {
        return "bbbbbbbbb!!!!!!!!!!!";
    }
}