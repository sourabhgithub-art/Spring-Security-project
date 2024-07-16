package com.spring_boot_security.Spring_boot_Security.services;
import com.spring_boot_security.Spring_boot_Security.dao.UserDao;
import com.spring_boot_security.Spring_boot_Security.model.*;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private UserDao userDao;
    public UsersModel addUser(UsersModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
     UsersModel us = userDao.save(user);
     return us;
    }

    public List<UsersModel> getUsers() {
        List<UsersModel> l = new ArrayList<>();
        l = userDao.findAll();
        return l;
    }
}
