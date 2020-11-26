package com.example.demo.restapi;

import com.example.demo.restapi.response.BaseResponse;
import com.example.demo.security.SecurityDefinations;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(method = RequestMethod.GET, path = "/testRoleUser")
    @Secured(SecurityDefinations.ROLE_USER)
    public BaseResponse testUser() {
        return BaseResponse.success();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/testRoleAdmin")
    @Secured(SecurityDefinations.ROLE_ADMIN)
    public BaseResponse testAdmin() {
        return BaseResponse.success();
    }
}
