package com.example.demo.restapi;

import com.example.demo.restapi.response.BaseResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 默认错误接口
 */
@RestController
public class CommonErrorController implements ErrorController {

    @RequestMapping(method = RequestMethod.GET, path = "/error")
    BaseResponse test() {
        return BaseResponse.error(1, "服务内部错误");
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
