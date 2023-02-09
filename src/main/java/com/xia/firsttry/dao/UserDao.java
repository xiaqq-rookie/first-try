package com.xia.firsttry.dao;

import com.xia.firsttry.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User getByUsernameAndPassword(String username, String password);
}
