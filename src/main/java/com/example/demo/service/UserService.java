package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User findUserByName(String name);

    void saveUser(User user);
}
