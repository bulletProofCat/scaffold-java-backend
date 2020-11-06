package com.example.demo.restapi;

import com.example.demo.response.BaseResponse;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(path = "/testRoleUser")
    @Secured("ROLE_USER")
    public BaseResponse testUser() {
        return BaseResponse.success();
    }

    @RequestMapping(path = "/testRoleAdmin")
    @Secured("ROLE_ADMIN")
    public BaseResponse testAdmin() {
        return BaseResponse.success();
    }

}
