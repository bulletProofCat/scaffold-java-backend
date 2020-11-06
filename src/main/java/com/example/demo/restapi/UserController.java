package com.example.demo.restapi;

import com.example.demo.response.BaseResponse;
import com.example.demo.restapi.request.RegistrationRequest;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.POST, path = "/rest/user/register")
    public BaseResponse register(@RequestBody RegistrationRequest registrationRequest) {
        try {
            userService.saveUser(registrationRequest.toUser(passwordEncoder));
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            return BaseResponse.error(1, "register fail, duplicate user name/phone/email");
        }
        return BaseResponse.success("");
    }

}
