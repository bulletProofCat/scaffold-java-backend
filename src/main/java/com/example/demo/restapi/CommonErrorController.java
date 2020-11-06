package com.example.demo.restapi;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonErrorController implements ErrorController {

    @RequestMapping(method = RequestMethod.GET, path = "/error")
    String test() {
        return "{error: 1}";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
