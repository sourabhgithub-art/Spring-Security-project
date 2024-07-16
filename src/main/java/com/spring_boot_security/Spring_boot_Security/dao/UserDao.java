package com.spring_boot_security.Spring_boot_Security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring_boot_security.Spring_boot_Security.model.*;
public interface UserDao extends JpaRepository<UsersModel,Integer> {
    UsersModel findByUsername(String username);
}
