package com.example.demo.restapi.request;

import com.example.demo.entity.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationRequest {
    private String name;

    private String password;

    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setName(name);
        user.setPassword(passwordEncoder.encode(password));
        user.setPhone(phone);
        return user;
    }

}
