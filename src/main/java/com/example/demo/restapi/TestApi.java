package com.example.demo.restapi;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

    @Autowired
    private SqlSession session;

    @RequestMapping(method = RequestMethod.GET, path = "/test")
    String test() {
        return session.toString();
    }
}
