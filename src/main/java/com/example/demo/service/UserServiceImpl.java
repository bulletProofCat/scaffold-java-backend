package com.example.demo.service;

import com.example.demo.data.UserRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User findUserByName(String name) {
        return userRepo.findByName(name);
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }
}
