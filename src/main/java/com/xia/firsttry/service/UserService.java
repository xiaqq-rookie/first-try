package com.xia.firsttry.service;

import com.xia.firsttry.dao.UserDao;
import com.xia.firsttry.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null != user;
    }

    public User getByName(String username) {
        return userDao.findByUsername(username);
    }

    public User getByUsernameAndPassword(String username, String password) {
        return userDao.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userDao.save(user);
    }

}
