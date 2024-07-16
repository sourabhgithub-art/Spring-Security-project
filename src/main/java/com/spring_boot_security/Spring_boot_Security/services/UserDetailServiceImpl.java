package com.spring_boot_security.Spring_boot_Security.services;

import com.spring_boot_security.Spring_boot_Security.dao.UserDao;
import com.spring_boot_security.Spring_boot_Security.model.UsersModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersModel user = userDao.findByUsername(username);
        if(user != null){
            UserDetails userDetails = User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles("USER")
                    .build();
            return userDetails;
        }
        throw new UsernameNotFoundException("User not found with this credentials");
    }
}

