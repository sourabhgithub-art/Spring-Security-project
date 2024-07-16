package com.spring_boot_security.Spring_boot_Security.controller;

import com.spring_boot_security.Spring_boot_Security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.spring_boot_security.Spring_boot_Security.model.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("addUsers")
    public ResponseEntity<UsersModel> addUser(@RequestBody UsersModel user){
        UsersModel us = null;
        try{
            us = userService.addUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(us, HttpStatus.CREATED);
    }
    @GetMapping("getUsers")
    public ResponseEntity<List<UsersModel>> getUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        String userName = auth.getName();
        try {
            return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
}
