package com.example.demo.restapi;

import com.example.demo.response.BaseResponse;
import com.example.demo.restapi.request.RegistrationRequest;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(path = "/user/register")
    public BaseResponse register(@RequestBody RegistrationRequest registrationRequest) {
        userService.saveUser(registrationRequest.toUser(passwordEncoder));
        return BaseResponse.success("");
    }

}
